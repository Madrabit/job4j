package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

/**
 * @author madrabit
 * Database store Vacancies
 * Name / Vacancy description / URL
 */
public class DataBase {
    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger(DataBase.class.getName());
    /**
     * Connection field
     */
    private Connection connection;

    /**
     * Init connect with Database and create table "task" if not exist.
     *
     * @return result of init
     */
    public boolean init() {
        try (InputStream in = DataBase.class.getClassLoader().getResourceAsStream("parser.properties")) {
            Properties config = new Properties();
            config.load(Objects.requireNonNull(in));
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            Statement st = connection.createStatement();
            st.executeUpdate("DROP TABLE IF EXISTS vacancy;"
                    + "CREATE TABLE vacancy (id serial PRIMARY KEY, name VARCHAR(255), description text, link VARCHAR(255))");
            st.close();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return this.connection != null;
    }

    public Connection getConnection() {
        return connection;
    }

    /**
     * Add vacancies.
     */
    public void add(Set<Vacancy> vacancies) {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (PreparedStatement st = connection.prepareStatement("INSERT INTO vacancy(name, description, link) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            for (Vacancy vacancy : vacancies) {
                st.setString(1, vacancy.getName());
                st.setString(2, vacancy.getText());
                st.setString(3, vacancy.getLink());
                st.addBatch();
            }
            st.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    /**
     * Update vacancies.
     */
    public void update(Set<Vacancy> vacancies) {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (PreparedStatement st = connection.prepareStatement("INSERT INTO vacancy(name, description, link) VALUES (?, ?, ?)"
                        + "ON CONFLICT DO NOTHING", Statement.RETURN_GENERATED_KEYS)) {
            for (Vacancy vacancy : vacancies) {
                st.setString(1, vacancy.getName());
                st.setString(2, vacancy.getText());
                st.setString(3, vacancy.getLink());
                st.addBatch();
            }
            st.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

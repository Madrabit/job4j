package ru.job4j.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author madrabit
 */
public class StoreSQL implements AutoCloseable {
    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger(StoreSQL.class.getName());
    private final List<XmlUsage.Field> fields = new LinkedList<>();

    private Connection connect;

    public StoreSQL(Config config) {
        CreateDB.createNewDatabase("magnit");
        try {
            Class.forName(config.get("driver-class-name"));
        } catch (ClassNotFoundException e) {
            LOG.error(e.getMessage(), e);
        }
        try {
            this.connect = DriverManager.getConnection(
                    config.get("url"),
                    config.get("username"),
                    config.get("password")
            );
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }

        try (Statement st = Objects.requireNonNull(connect).createStatement()) {
            st.execute("DROP TABLE IF EXISTS entry;");
            st.executeUpdate("CREATE TABLE entry (field INT)");
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Generate fields.
     *
     * @param size N number.
     */
    public void generate(int size) {
        try {
            connect.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (PreparedStatement st = connect.prepareStatement("INSERT INTO entry(field) VALUES (?)")) {
            for (int i = 0; i < size; i++) {
                st.setInt(1, i);
                st.addBatch();
            }
            st.executeBatch();
            st.close();
            connect.commit();
            connect.setAutoCommit(true);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
            try {
                connect.rollback();
            } catch (SQLException ex) {
                LOG.error(e.getMessage(), e);
            }
        }
        fieldsSelection();
    }


    /**
     * Get Field from Database and generate XML
     */
    private void fieldsSelection() {
        try (PreparedStatement st = connect.prepareStatement("SELECT field FROM entry");
             ResultSet result = st.executeQuery()) {
            while (result.next()) {
                fields.add(new XmlUsage.Field(result.getInt(1)));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public List<XmlUsage.Field> getFields() {
        return fields;
    }


    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }

}

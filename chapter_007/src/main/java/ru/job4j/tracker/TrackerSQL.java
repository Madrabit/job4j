package ru.job4j.tracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/**
 * @author madrabit
 * Program Tracker connected with SQL. Has CRUD operations and more.
 */
public class TrackerSQL implements ITracker, AutoCloseable {
    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class.getName());
    /**
     * Connection field
     */
    private Connection connection;

    /**
     * Init connect with Database and create table "task" if not exist.
     *
     * @return ???
     */
    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(Objects.requireNonNull(in));
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            Statement st = connection.createStatement();
            st.executeUpdate("DROP TABLE IF EXISTS task;"
                    + "CREATE TABLE task (id serial PRIMARY KEY, task_name VARCHAR(50), description VARCHAR(50), date TIMESTAMP without time zone)");
//           st.executeUpdate("CREATE TABLE task (id serial PRIMARY KEY, task_name VARCHAR(50), description VARCHAR(50), date TIMESTAMP)");
            st.close();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return this.connection != null;
    }

    /**
     * Add an item.
     *
     * @param item Some task.
     * @return ???
     */
    public Item add(Item item) {
        try (PreparedStatement st = connection.prepareStatement("INSERT INTO task(task_name, description, date) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, item.getName());
            st.setString(2, item.getDesc());
            st.setTimestamp(3, new Timestamp(item.getTime()));
            st.executeUpdate();
            ResultSet key = st.getGeneratedKeys();
            if (key.next()) {
                item.setId(key.getString(1));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }

        return item;
    }

    /**
     * Edit task
     *
     * @param id   Target item.
     * @param item New data for item.
     * @return Result.
     */
    @Override
    public boolean replace(String id, Item item) {
        int result = 0;
        try (PreparedStatement st = connection.prepareStatement("UPDATE task SET task_name = ?, description = ?, date = ? WHERE id =  ?")) {
            st.setString(1, item.getName());
            st.setString(2, item.getDesc());
            st.setTimestamp(3, new Timestamp(item.getTime()));
            st.setInt(4, Integer.parseInt(id));
            result = st.executeUpdate();
            System.out.println(result);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result >= 1;
    }

    /**
     * Delete an Item from base.
     *
     * @param id Target.
     * @return Result of delete.
     */
    @Override
    public boolean delete(String id) {
        int result = 0;
        try (PreparedStatement st = connection.prepareStatement("DELETE FROM task WHERE id =  ?")) {
            st.setInt(1, Integer.parseInt(id));
            result = st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result >= 1;

    }

    /**
     * Find all Items.
     *
     * @return List of all Items from database.
     */
    @Override
    public List<Item> findAll() {
        List<Item> items = new LinkedList<>();
        try (PreparedStatement st = connection.prepareStatement("SELECT * FROM task")) {
            ResultSet result = st.executeQuery();
            while (result.next()) {
                items.add(new Item(result.getString("task_name"), result.getString("description"), System.currentTimeMillis()));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return items;
    }

    /**
     * Find an item by name.
     *
     * @param key target name.
     * @return Return List of items.
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new LinkedList<>();
//        Item item = new Item("", "", 0L);
        try (PreparedStatement st = connection.prepareStatement("SELECT * FROM task WHERE task_name =  ?")) {
            st.setString(1, key);
            ResultSet result = st.executeQuery();
            while (result.next()) {
                items.add(new Item(result.getString("task_name"), result.getString("description"), result.getTimestamp("date").getTime()));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return items;
    }

    /**
     * Find an item by ID.
     *
     * @param id Target Id.
     * @return Item.
     */
    @Override
    public Item findById(String id) {
        Item item = new Item("", "", 0);
        try (PreparedStatement st = connection.prepareStatement("SELECT * FROM task WHERE id =  ?")) {
            st.setInt(1, Integer.parseInt(id));
            ResultSet result = st.executeQuery();
            while (result.next()) {
                item.setId(result.getString("id"));
                item.setName(result.getString("task_name"));
                item.setDecs(result.getString("description"));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return item;
    }

    /**
     * Clear table from any data.
     *
     * @param table Target table.
     */
    public void clearTable(String table) {
        try (PreparedStatement st = connection.prepareStatement("TRUNCATE task; \n ALTER SEQUENCE task_id_seq RESTART WITH 1")) {
            st.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Close connection.
     */
    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}

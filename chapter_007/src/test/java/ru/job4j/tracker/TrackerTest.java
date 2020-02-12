package ru.job4j.tracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit
 */
public class TrackerTest {
    private TrackerSQL sql;
    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class.getName());

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(Objects.requireNonNull(in));
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
//    public void initBase() {
//        sql = new TrackerSQL();
//        sql.init();
//    }

    @Test
    public void createItem() {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.add(new Item("name", "desc", System.currentTimeMillis()));
            assertThat(sql.findByName("name").size(), is(2));
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }

    }

    @Test
    public void findByIDReturnFirstItem() {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.add(new Item("name", "desc", System.currentTimeMillis()));
            Item newItem = sql.findById("1");
            assertThat(newItem.getName(), is("name"));
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Test
    public void findByNameReturnFirstTask() {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.add(new Item("1 task", "Some description", System.currentTimeMillis()));
            sql.add(new Item("2 task", "Any description", System.currentTimeMillis()));
            List<Item> items = sql.findByName("1 task");
            boolean result = items.stream().map(Item::getName).anyMatch(s -> Objects.equals(s, "1 task"));
            assertThat(result, is(true));
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }


    @Test
    public void findAllReturnSize2() {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.add(new Item("1 task", "Some description", System.currentTimeMillis()));
            sql.add(new Item("2 task", "Any description", System.currentTimeMillis()));
            List<Item> items = sql.findAll();
            assertThat(items.size(), is(3));
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Test
    public void deleteReturnsTrue() {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.add(new Item("1 task", "Some description", System.currentTimeMillis()));
            boolean result = sql.delete("1");
            assertThat(result, is(true));
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Test
    public void replace() {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = new Item("Edited task", "Edited description", System.currentTimeMillis());
            boolean result = sql.replace("1", item);
            assertThat(result, is(true));
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}

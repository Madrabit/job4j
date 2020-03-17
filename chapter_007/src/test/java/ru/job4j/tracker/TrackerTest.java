package ru.job4j.tracker;

import org.junit.Test;

import java.io.IOException;
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

    public Connection init() throws IOException, ClassNotFoundException, SQLException {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(Objects.requireNonNull(in));
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        }
    }

//    @Test
//    public void initTest() {
//        sql = new TrackerSQL();
//        sql.init();
//    }

    @Test
    public void createItem() throws SQLException, IOException, ClassNotFoundException {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.add(new Item("name", "desc", System.currentTimeMillis()));
            assertThat(sql.findByName("name").size(), is(1));
        }
    }

    @Test
    public void findByIDReturnFirstItem() throws SQLException, IOException, ClassNotFoundException {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = sql.add(new Item("name", "desc", System.currentTimeMillis()));
            Item newItem = sql.findById(item.getId());
            assertThat(newItem.getName(), is("name"));
        }
    }

    @Test
    public void findByNameReturnFirstTask() throws SQLException, IOException, ClassNotFoundException {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.add(new Item("1 task", "Some description", System.currentTimeMillis()));
            sql.add(new Item("2 task", "Any description", System.currentTimeMillis()));
            List<Item> items = sql.findByName("1 task");
            boolean result = items.stream().map(Item::getName).anyMatch(s -> Objects.equals(s, "1 task"));
            assertThat(result, is(true));
        }
    }


    @Test
    public void findAllReturnSize2() throws SQLException, IOException, ClassNotFoundException {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.add(new Item("1 task", "Some description", System.currentTimeMillis()));
            sql.add(new Item("2 task", "Any description", System.currentTimeMillis()));
            List<Item> items = sql.findAll();
            assertThat(items.size(), is(2));
        }
    }

    @Test
    public void deleteReturnsTrue() throws SQLException, IOException, ClassNotFoundException {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = sql.add(new Item("1 task", "Some description", System.currentTimeMillis()));
            boolean result = sql.delete(item.getId());
            assertThat(result, is(true));
        }
    }

    @Test
    public void replace() throws SQLException, IOException, ClassNotFoundException {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = sql.add(new Item("1 task", "Some description", System.currentTimeMillis()));
            Item newItem = new Item("Edited task", "Edited description", System.currentTimeMillis());
            boolean result = sql.replace(item.getId(), newItem);
            assertThat(result, is(true));
        }
    }
}

package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * @author madrabit
 */
public class TrackerTest {
    private TrackerSQL sql;

    @Before
    public void initBase() {
        sql = new TrackerSQL();
        sql.init();
    }

    @Test
    public void checkConnection() {
        boolean result = sql.init();
        sql.close();
        assertThat(sql.init(), is(true));
    }

    @Test
    public void addItem() {
        Item item = new Item("First task", "Some description");
        Item item2 = new Item("Second task", "Next description");
        sql.init();
        sql.add(item);
        sql.init();
        sql.add(item2);
        assertThat(sql.init(), is(true));
    }

    @Test
    public void findByIDReturnFirstItem() {
        Item newItem = sql.findById("1");
        String result = newItem.getName();
        assertThat(result, is("First task"));
    }

    @Test
    public void findByNameReturnFirstTask() {
        clearTable();
        addItem();
        List<Item> items = sql.findByName("First task");
        boolean result = items.stream().map(Item::getName).anyMatch(s -> Objects.equals(s, "First task"));
        assertThat(result, is(true));
    }

    @Test
    public void findAllReturnSize2() {
        clearTable();
        sql.init();
        addItem();
        sql.init();
        List<Item> items = sql.findAll();
        assertThat(items.size(), is(2));
    }

    @Test
    public void clearTable() {
        sql.clearTable("task");
    }

    @Test
    public void deleteReturnsTrue() {
        sql.init();
        clearTable();
        addItem();
        boolean result = sql.delete("1");
        assertThat(result, is(true));
    }

    @Test
    public void replace() {
        Item item = new Item("Edited task", "Edited description");
        sql.init();
        sql.replace("1", item);
//        assertThat(result, is(true));
    }
}

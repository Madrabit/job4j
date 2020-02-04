package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
        assertThat(sql.init(), is(true));
    }

    @Test
    public void findByIDReturnFirstItem() {
        Item item = new Item("First task", "Some description", System.currentTimeMillis());
        sql.add(item);
        Item newItem = sql.findById("1");
        assertThat(newItem.getName(), is("First task"));
    }

    @Test
    public void findByNameReturnFirstTask() {
        sql.add(new Item("1 task", "Some description", System.currentTimeMillis()));
        sql.add(new Item("2 task", "Any description", System.currentTimeMillis()));
        List<Item> items = sql.findByName("1 task");
        boolean result = items.stream().map(Item::getName).anyMatch(s -> Objects.equals(s, "1 task"));
        assertThat(result, is(true));
    }

    @Test
    public void findAllReturnSize2() {
        sql.init();
        sql.add(new Item("1 task", "Some description", System.currentTimeMillis()));
        sql.add(new Item("2 task", "Any description", System.currentTimeMillis()));
        List<Item> items = sql.findAll();
        assertThat(items.size(), is(2));
    }

    @Test
    public void deleteReturnsTrue() {
        sql.init();
        sql.add(new Item("1 task", "Some description", System.currentTimeMillis()));
        boolean result = sql.delete("1");
        assertThat(result, is(true));
    }

    @Test
    public void replace() {
        Item item = new Item("Edited task", "Edited description", System.currentTimeMillis());
        sql.init();
        sql.replace("1", item);
    }
}

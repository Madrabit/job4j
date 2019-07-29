package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit on 27.07.2019
 * @version 1$
 * @since 0.1
 */
public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenTrue() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", System.currentTimeMillis());
        Item item2 = new Item("test1", "testDescription", System.currentTimeMillis());
        Item item3 = new Item("test1", "testDescription", System.currentTimeMillis());
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        boolean result = tracker.delete(item2.getId());
        assertThat(result, is(true));
    }
}

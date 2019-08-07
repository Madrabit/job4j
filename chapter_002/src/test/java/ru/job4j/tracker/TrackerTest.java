package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

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

    @Test
    public void whenTrackerEnumThenOneInstance() {
        TrackerSingleEnum tracker1 = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum tracker2 = TrackerSingleEnum.INSTANCE;
        assertSame(tracker1, tracker2);
    }

    @Test
    public void whenTrackerStaticFieldThenSingleton() {
        TrackerSingleStaticField tracker1 = TrackerSingleStaticField.getInstance();
        TrackerSingleStaticField tracker2 = TrackerSingleStaticField.getInstance();
        assertSame(tracker1, tracker2);
    }

    @Test
    public void whenTrackerStaticFinalFieldThenSingleton() {
        TrackerSingleStaticFinalField tracker1 = TrackerSingleStaticFinalField.getInstance();
        TrackerSingleStaticFinalField tracker2 = TrackerSingleStaticFinalField.getInstance();
        assertSame(tracker1, tracker2);
    }

    @Test
    public void whenTrackerPrivateStaticFieldThenSingleton() {
        TrackerSinglePrivateStaticFinal tracker1 = TrackerSinglePrivateStaticFinal.getInstance();
        TrackerSinglePrivateStaticFinal tracker2 = TrackerSinglePrivateStaticFinal.getInstance();
        assertSame(tracker1, tracker2);
    }
}

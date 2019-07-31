package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author madrabit on 30.07.2019
 * @version 1$
 * @since 0.1
 */
public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        String result = tracker.findById(item.getId()).getName();
        assertThat(result, is("test replace"));
    }

    @Test
    public void whenFindAllThenTrackerReturnAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        int result = tracker.getPosition();
        assertThat(result, is(2));
    }

    @Test
    public void whenDeleteThenTrackerReturnTrue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        int original = tracker.getPosition();
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        int result = tracker.getPosition();
        assertThat(result, is(original - 1));
    }


    @Test
    public void whenFindByNameThenReturnItemsWithName() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        Item item3 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", "test name1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName() + tracker.findAll()[2].getName(), is("test name1" + "test name1"));
    }

    @Test
    public void whenFindByIdThenFoundItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(item1.getName(), is("test name1"));
    }

    @Test
    public void whenFindByIdThenItemOut() {

        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", item1.getId(), "6"});
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                    .append("test name1")
                    .append("desc")
                    .append(System.lineSeparator())
                    .toString()
        ));
        System.setOut(stdout);
    }
}

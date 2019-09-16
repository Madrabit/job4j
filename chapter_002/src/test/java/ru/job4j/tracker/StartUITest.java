package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author madrabit on 30.07.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("StringBufferReplaceableByString")
public class StartUITest {
    final StringBuilder menu = new StringBuilder()
            .append("Add new Item.")
            .append(System.lineSeparator())
            .append("Show All Items.")
            .append(System.lineSeparator())
            .append("Update Item")
            .append(System.lineSeparator())
            .append("Delete Item")
            .append(System.lineSeparator())
            .append("Find Item by ID")
            .append(System.lineSeparator())
            .append("Find Items by Name")
            .append(System.lineSeparator());
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final PrintStream stdout = new PrintStream(out);
    private final Consumer<String> output = new Consumer<String>() {
        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(out));

    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        new StartUI(input, tracker, output).init();
        String result = tracker.findById(item.getId()).getName();
        assertThat(result, is("test replace"));
    }

    @Test
    public void whenFindAllThenTrackerReturnAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker, output).init();
        int result = tracker.getPosition();
        assertThat(result, is(2));
    }

    @Test
    public void whenDeleteThenTrackerReturnTrue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        int original = tracker.getPosition();
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
        new StartUI(input, tracker, output).init();
        int result = tracker.getPosition();
        assertThat(result, is(original - 1));
    }


    @Test
    public void whenFindByNameThenReturnItemsWithName() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        Item item3 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", "test name1", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName() + tracker.findAll().get(2).getName(), is("test name1" + "test name1"));
    }

    @Test
    public void whenFindByIdThenFoundItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        String id = item1.getId();
        Input input = new StubInput(new String[]{"4", id, "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getId(), is(id));
    }

    @Test
    public void whenFindByIdThenItemOut() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", item1.getId(), "y"});
        new StartUI(input, tracker, output).init();
        assertEquals(new String(out.toByteArray()), new StringBuilder()
                .append(menu)
                .append("------------ Поиск заявки по ID --------------")
                .append(System.lineSeparator())
                .append("------------ Найденная заявка: ")
                .append("test name1")
                .append("-----------")
                .append("desc")
                .append(System.lineSeparator())
                .toString()
        );
    }

    @Test
    public void whenFindByNameThenReturnItemsWithNameBinary() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        Item item3 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", "test name1", "y"});
        new StartUI(input, tracker, output).init();
        assertEquals(new String(out.toByteArray()), new StringBuilder()
                .append(menu)
                .append("------------ Поиск заявки по имени --------------")
                .append(System.lineSeparator())
                .append("------------ Найденная заявка: test name1-----------desc")
                .append(System.lineSeparator())
                .append("------------ Найденная заявка: test name1-----------desc")
                .append(System.lineSeparator())
                .toString()
        );
    }
}

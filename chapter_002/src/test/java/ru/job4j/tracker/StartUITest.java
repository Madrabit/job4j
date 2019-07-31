package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author madrabit on 30.07.2019
 * @version 1$
 * @since 0.1
 */
public class StartUITest {
    final String menu = "Меню."
            + System.lineSeparator()
            + "--------------"
            + System.lineSeparator()
            + "Создать заявку - 0"
            + System.lineSeparator()
            + "Показать список заявок - 1"
            + System.lineSeparator()
            + "Редактировать заявку - 2"
            + System.lineSeparator()
            + "Удалить заявку - 3"
            + System.lineSeparator()
            + "Найти заявку по ID - 4"
            + System.lineSeparator()
            + "Найти все заявки по назаванию - 5"
            + System.lineSeparator() + "Выйти - 6"
            + System.lineSeparator();
    final PrintStream stdout = System.out;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
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
        String id = item1.getId();
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getId(), is(id));
    }

    @Test
    public void whenFindByIdThenItemOut() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertEquals(new String(out.toByteArray()), menu
                + "------------ Поиск заявки по ID --------------"
                + System.lineSeparator()
                + "------------ Найденная заявка: "
                + "test name1"
                + "-----------"
                + "desc"
                + System.lineSeparator()
                + menu);
    }

    @Test
    public void whenFindByNameThenReturnItemsWithNameBinary() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        Item item3 = tracker.add(new Item("test name1", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", "test name1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(menu
                + "------------ Поиск заявки по имени --------------"
                + System.lineSeparator()
                + "------------ Найденная заявка: test name1-----------desc"
                + System.lineSeparator()
                + "------------ Найденная заявка: test name1-----------desc"
                + System.lineSeparator()
                + menu));
    }
}

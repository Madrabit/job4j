package ru.job4j.design.isp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * @author madrabit
 */
public class MenuTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenExpected21lvlThenReturnUnder211And212() {
        Menu<String> menu = new Menu<>("start");
        menu.add("start", "Задача 1");
        menu.add("start", "Задача 2");
        menu.add("Задача 1", "Задача 1.2");
        menu.add("Задача 1", "Задача 1.2");
        menu.add("Задача 2", "Задача 2.1");
        menu.add("Задача 2", "Задача 2.2");
        menu.add("Задача 2.1", "Задача 2.1.1");
        menu.add("Задача 2.1", "Задача 2.1.2");
        menu.show("Задача 2.1");

        String expected = "Задача 2.1" + System.lineSeparator()
                + "Задача 2.1.1" + System.lineSeparator()
                + "Задача 2.1.2" + System.lineSeparator();

        assertEquals(expected, this.mem.toString());
    }
}

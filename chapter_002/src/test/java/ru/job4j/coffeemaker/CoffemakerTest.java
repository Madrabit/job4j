package ru.job4j.coffeemaker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.coffemaker.Coffeemaker;

import static org.hamcrest.Matchers.is;

/**
 * @author madrabit on 15.08.2019
 * @version 1$
 * @since 0.1
 */
public class CoffemakerTest {
    @Test
    public void whenAdd50Then35() {
        Coffeemaker coffeemaker = new Coffeemaker();
        int[] result =  coffeemaker.changes(50, 35);
        int[] expected = {10, 5};
        Assert.assertThat(result, is(expected));
    }
    @Test
    public void whenAdd50Then32() {
        Coffeemaker coffeemaker = new Coffeemaker();
        int[] result =  coffeemaker.changes(50, 32);
        int[] expected = {10, 5, 2, 1};
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenAdd50Then25() {
        Coffeemaker coffeemaker = new Coffeemaker();
        int[] result =  coffeemaker.changes(50, 25);
        int[] expected = {10, 10, 5};
        Assert.assertThat(result, is(expected));
    }
}

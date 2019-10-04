package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit on 03.10.2019
 * @version 1$
 * @since 0.1
 */
public class SimpleArrayTest {

    @Test
    public void whenAdd1ThenGet1() {
        SimpleArray<Integer> integerSimpleArray = new SimpleArray<>(Integer.class, 10);
        integerSimpleArray.add(1);
        int result = integerSimpleArray.get(0);
        assertThat(1, is(result));
    }

    @Test
    public void remove() {
        SimpleArray<Integer> integerSimpleArray = new SimpleArray<>(Integer.class, 10);
        integerSimpleArray.add(1);
        integerSimpleArray.add(2);
        integerSimpleArray.remove(0);
        int result = integerSimpleArray.get(0);
        assertThat(2, is(result));
    }

    @Test
    public void set() {
        SimpleArray<Integer> integerSimpleArray = new SimpleArray<>(Integer.class, 10);
        integerSimpleArray.add(1);
        integerSimpleArray.set(0, 2);
        int result = integerSimpleArray.get(0);
        assertThat(2, is(result));
    }
}

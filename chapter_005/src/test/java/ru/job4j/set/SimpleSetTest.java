package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit on 15.10.2019
 * @version 1$
 * @since 0.1
 */
public class SimpleSetTest {
    @Test
    public void whenAdd121ThenLastElementNull() {
        SimpleSet<Integer> set = new SimpleSet<>(3);
        set.add(1);
        set.add(2);
        set.add(1);

        assertThat(set.get(3), is(0));
    }
}

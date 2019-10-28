package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit on 15.10.2019
 * @version 1$
 * @since 0.1
 */
public class SimpleSetTest {
    private final SimpleSet<Integer> set = new SimpleSet<>(3);

    @Test
    public void whenAddDuplicateShouldReturnFalse() {
        set.add(1);
        set.add(null);
        set.add(2);
        set.add(2);
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
        assertNull(it.next());
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
    }
}

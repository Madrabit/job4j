package ru.job4j.array;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit on 24.07.19
 * @version 1$
 * @since 0.1
 */
public class CheckIsSortedTest {
    @Test
    public void whenIsSortedThenTrue() {
        CheckIsSorted sorted = new CheckIsSorted();
        boolean result = sorted.isSorted(new int[] {1, 2, 3, 4});
        assertThat(true, is(result));
    }
    @Test
    public void whenIsSortedThenFalse() {
        CheckIsSorted sorted = new CheckIsSorted();
        boolean result = sorted.isSorted(new int[] {1, 4, 3, 2});
        assertThat(false, is(result));
    }
}

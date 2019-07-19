package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit on 19.07.19
 * @version 1$
 * @since 0.1
 */
public class FindLoopTest {
    @Test
    public void whenArrayHas5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHas3Then3() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 7, 3};
        int value = 3;
        int result = find.indexOf(input, value);
        int expect = 3;
        assertThat(result, is(expect));
    }
}

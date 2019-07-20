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

    @Test
    public void whenFind3() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 2, 10, 2, 4};
        int value = 4;
        int start = 2;
        int finish = 4;
        int result = find.indexOf(input, value, start, finish);
        int expect = 4;
        assertThat(result, is(expect));
    }

    @Test
    public void whenCantFind7() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 2, 10, 2, 4};
        int value = 7;
        int start = 0;
        int finish = 2;
        int result = find.indexOf(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort5() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {3, 4, 1, 2, 5};
        int[] result = find.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort3() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {3, 2, 1};
        int[] result = find.sort(input);
        int[] expect = new int[] {1, 2, 3};
        assertThat(result, is(expect));
    }
}

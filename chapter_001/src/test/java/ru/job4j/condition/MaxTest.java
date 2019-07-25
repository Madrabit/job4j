package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit
 * @version $Id$
 * @since 0.1
 */

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax5o1Then2() {
        Max max = new Max();
        int result = max.max(5, 1);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax3To3Then3() {
        Max max = new Max();
        int result = max.max(3, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax3To2To1Then3() {
        Max max = new Max();
        int result = max.max(3, 2, 1);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax3To2ToTo4To1Then4() {
        Max max = new Max();
        int result = max.max(3, 2, 4, 1);
        assertThat(result, is(4));
    }
}

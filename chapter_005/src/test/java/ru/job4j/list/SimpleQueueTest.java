package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit on 17.10.2019
 * @version 1$
 * @since 0.1
 */
public class SimpleQueueTest {
    private SimpleQueue<Integer> queue;

    @Before
    public void beforeTest() {
        queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
    }

    @Test
    public void whenFirstAdd1ThenDeleteReturn1() {
        int result = queue.poll();
        assertThat(result, is(1));
    }
}

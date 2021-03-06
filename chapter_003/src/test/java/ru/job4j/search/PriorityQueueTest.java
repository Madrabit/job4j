package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit on 22.08.2019
 * @version 1$
 * @since 0.1
 */
public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("low", 5));
        queue.put(new Task("low8", 8));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));

    }
}

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
public class SimpleStackTest {
    private SimpleStack<Integer> stack;

    @Before
    public void beforeTest() {
        stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
    }

    @Test
    public void whenLastAdd3ThenDeleteReturn3() {
        stack.push(3);
        int result = stack.poll();
        assertThat(result, is(3));
    }
}

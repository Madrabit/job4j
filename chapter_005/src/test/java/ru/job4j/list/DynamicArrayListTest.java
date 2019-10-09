package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author madrabit on 09.10.2019
 * @version 1$
 * @since 0.1
 */
public class DynamicArrayListTest {
    @Test
    public void whenAddOutOfBoundThenSize3() {
        DynamicArrayList<Integer> dynamicArrayList = new DynamicArrayList<>(2);
        for (int i = 0; i < dynamicArrayList.getSize(); i++) {
            dynamicArrayList.add(1);
        }
        dynamicArrayList.add(2);
        assertThat(dynamicArrayList.getSize(), is(3));
    }
}

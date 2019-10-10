package ru.job4j.list;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * @author madrabit on 09.10.2019
 * @version $
 * @since 0.1
 */
public class DynamicArrayListTest {
    private DynamicArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new DynamicArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), Matchers.is(2));
    }

}

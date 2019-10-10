package ru.job4j.list;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.ListIterator;

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

    @Test
    public void checkIterator() {
        ListIterator<Integer> it = list.iterator();
        for (int i = 0; i < list.getSize(); i++) {
            list.add(1);
        }
        list.add(2);
        assertThat(list.getSize(), is(3));
    }

}

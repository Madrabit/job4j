package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author madrabit on 01.10.2019
 * @version $
 * @since 0.1
 */
@SuppressWarnings("unchecked")
public class MatrixIteratorTest {
    private Iterator<Integer> it;

    @Before
    public void setUp() {
        it = new MatrixIterator(new int[][]{{1}, {3, 4}, {7}});
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void hasNext() {
        it.hasNext();
        boolean result = it.hasNext();
        assertThat(result, is(true));
    }
}

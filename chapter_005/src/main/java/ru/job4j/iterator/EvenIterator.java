package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Even Iterator
 *
 * @author madrabit on 02.10.2019
 * @version 1$
 * @since 0.1
 */
public class EvenIterator implements Iterator {

    /**
     * Input Arrays
     */
    private final int[] values;
    /**
     * Cursor position
     */
    private int index = 0;

    public EvenIterator(int[] values) {
        this.values = values;
    }

    /**
     * Check array by even
     *
     * @return Result has even or not
     */
    @Override
    public boolean hasNext() {
        while (values.length > index) {
            if (values[index] % 2 == 0) {
                return true;
            }
            index++;
        }
        return false;
    }

    /**
     * Move cursor forward and return even integer.
     *
     * @return Even integer.
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return values[index++];
    }
}

package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MatrixIterator
 *
 * @author madrabit on 01.10.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("rawtypes")
public class MatrixIterator implements Iterator {

    /**
     * Matrix - 2D Array
     */
    private final int[][] values;
    /**
     * Index of first stage array
     */
    private int outer = 0;
    /**
     * Index of second stage array
     */
    private int index = 0;

    public MatrixIterator(int[][] values) {
        this.values = values;
    }

    /**
     * Check first array has next element or not
     *
     * @return array is finished or not
     */
    @Override
    public boolean hasNext() {
        while (values.length > outer) {
            if (values.length != 0 && values[outer].length > index) {
                return true;
            } else {
                outer++;
                this.index = 0;
            }
        }
        return false;
    }

    /**
     * Moves cursor forward
     *
     * @return Current value
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return values[outer][index++];
    }
}

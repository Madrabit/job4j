package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MatrixIterator
 * @author madrabit on 01.10.2019
 * @version 1$
 * @since 0.1
 */
public class MatrixIterator implements Iterator {

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
     * Check first lvl array has next element or not
     * @return array is finished or not
     */
    @Override
    public boolean hasNext() {
        if (values.length > outer) {
            if (hasNextInside()) {
                return true;
            } else {
                outer++;
                if (values.length == outer) {
                    return false;
                }
                return hasNextInside();
            }
        } else {
            return false;
        }
    }

    /**
     * Check second lvl array has next element or not
     * @return array is finished or not
     */
    private boolean hasNextInside() {
        if (values[outer].length > index) {
            return true;
        } else {
            this.index = 0;
            return false;
        }
    }

    /**
     * Moves cursor forward
     * @return Current value
     */
    @Override
    public Object next() {
        if (hasNext()) {
            return innerNext();
        } else {
            outer++;
            return innerNext();
        }
    }

    /**
     *  Moves cursor forward in second array
     * @return Current value
     */
    private Object innerNext() {
        if (!hasNextInside()) {
          throw new NoSuchElementException();
        }
        return values[outer][index++];
    }
}

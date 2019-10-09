package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author madrabit on 09.10.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings({"unchecked", "TypeParameterHidesVisibleType"})
public class DynamicArrayList<T> implements Iterable<T> {
    private final T[] array;
    private int size;
    int position = 0;
    int modCount = 0;

    public DynamicArrayList(int size) {
        this.array = (T[]) new Object[size];
        this.size = size;
    }

    /**
     * Add element
     *
     * @param model Element for adding.
     */
    public void add(T model) {
        if (size == position + 1) {
            size = size + (size >> 1);
            modCount++;
        }
        array[position++] = model;
    }

    /**
     * Return object by index.
     *
     * @param index Index which to get.
     * @param <T>   Type of array.
     * @return Returning element.
     */
    public <T> T get(int index) {
        if (size == 0) {
            throw new NullPointerException();
        }
        if (position == 0 && index + 1 > position) {
            throw new NoSuchElementException();
        }
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = modCount;
        return new Iterator<>() {
            int index;

            /**
             * Check if item exists.
             *
             * @return Exists or not.
             */
            @Override
            public boolean hasNext() {
                if (expectedModCount == modCount) {
                    throw new ConcurrentModificationException();
                }
                return array.length > position;
            }

            /**
             * Move cursor froward and return item.
             *
             * @return Return item.
             */
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[index++];
            }
        };
    }
}

package ru.job4j.generic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Simple Array Box.
 *
 * @author madrabit on 03.10.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings({"unchecked", "TypeParameterHidesVisibleType"})
public class SimpleArray<T> implements Iterable<T> {
    /**
     * Current array.
     */
    private T[] array;
    /**
     * Not null arrays index.
     */
    int position = 0;
    /**
     * Index for iterator.
     */
    int index = 0;
    /**
     * Array length.
     */
    int size;

    public SimpleArray(Class<T> arr, int size) {
        this.array = (T[]) Array.newInstance(arr, size);
        this.size = size;
    }

    /**
     * Add element
     *
     * @param model Element for adding.
     */
    public void add(T model) {
        array[position++] = model;
    }

    /**
     * Remove element from array.
     *
     * @param index Index of deleted object.
     */
    public void remove(int index) {
        T[] temp = Arrays.copyOf(array, size - 1);
        System.arraycopy(array, index + 1, temp, index, --size);
        array = temp;
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

    /**
     * Update array element.
     *
     * @param index Index of updated object.
     * @param model New value for index.
     */
    public void set(int index, T model) {
        if (size == 0) {
            throw new NullPointerException();
        }
        if (position == 0 && index + 1 > position) {
            throw new NoSuchElementException();
        }
        array[index] = model;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            /**
             * Check if item exists.
             *
             * @return Exists or not.
             */
            @Override
            public boolean hasNext() {
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

package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * @author madrabit on 09.10.2019
 * @version 1$
 * @since 0.1
 */
public class DynamicArrayList<T> {
    /**
     * Current array.
     */
    private T[] container;
    private int size;
    int position;

    public DynamicArrayList(int size) {
        this.container = (T[]) new Object[size];
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
        }
        container[position++] = model;
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
        return (T) container[index];
    }
}

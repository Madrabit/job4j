package ru.job4j.set;

import ru.job4j.generic.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author madrabit on 15.10.2019
 * @version 1$
 * @since 0.1
 */
public class SimpleSet<T> implements Iterable<T> {
    /**
     * Container based on Simple Array List.
     */
    private final SimpleArray<T> container;


    public SimpleSet(int size) {
        container = new SimpleArray<>(size);
    }

    /**
     * Add unique element to container.
     *
     * @param e Element for adding.
     */
    public void add(T e) {
        if (!checkHas(e)) {
            container.add(e);
        }
    }

    /**
     * Check for an item.
     *
     * @param e Input item.
     * @return Result isHas.
     */
    private boolean checkHas(T e) {
        boolean result = false;
        for (T t : container) {
            if (t == e) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Iterator.
     *
     * @return Return new Iterator based on SimpleArray Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return container.iterator();
    }
}

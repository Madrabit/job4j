package ru.job4j.tracker;

/**
 * @author madrabit on 18.11.2020
 * @version 1$
 * @since 0.1
 */
public interface Observe<T> {
    void receive(T model);
}

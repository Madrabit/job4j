package ru.job4j.design.isp;

import java.util.Optional;

/**
 * @author madrabit
 * Creation menu Interface.
 */
public interface IMenu<E extends Comparable<E>> extends Iterable<E>   {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return result of adding.
     */
    boolean add(E parent, E child);

    Optional<Item<E>> findBy(E value);
}

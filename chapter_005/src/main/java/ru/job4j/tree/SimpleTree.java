package ru.job4j.tree;

import java.util.Optional;

/**
 * @author madrabit on 06.11.2019
 * @version 1$
 * @since 0.1
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E>  {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return result of adding.
     */
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}

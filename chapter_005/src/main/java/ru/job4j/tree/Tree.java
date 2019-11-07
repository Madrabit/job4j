package ru.job4j.tree;

import java.util.*;

/**
 * @author madrabit on 06.11.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings({"unchecked", "ConstantConditions"})
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Tree root.
     */
    private final Node<E> root;
    /**
     * Modification for checking collection was not changed while iterate
     */
    private int modCount;

    public Tree(int rootValue) {
        root = (Node<E>) new Node<>(rootValue);
    }

    /**
     * Adding a new item to the tree.
     *
     * @param parent parent. Parent where will be add.
     * @param child  child. Item for adding.
     * @return Result of adding.
     */
    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> root = findBy(parent);
        boolean result = false;
        if (root.isPresent()) {
            root.get().add(new Node<>(child));
            result = true;
        }
        return result;
    }

    /**
     * Finding element into the tree.
     *
     * @param value Searchable item.
     * @return Return item as Optional.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        return new Iterator<>() {
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return !data.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> el = data.poll();
                for (Node<E> child : el.leaves()) {
                    data.offer(child);
                }
                return el.getValue();
            }
        };
    }
}

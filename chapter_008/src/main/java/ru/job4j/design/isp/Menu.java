package ru.job4j.design.isp;

import java.util.*;

/**
 * @author madrabit
 */
public class Menu<E extends Comparable<E>> implements IMenu<E>, ShowMenu<E> {
    /**
     * Tree root.
     */
    private final Item<E> root;

    public Item<E> getRoot() {
        return root;
    }

    /**
     * Modification for checking collection was not changed while iterate
     */
    private int modCount;

    public Menu(E rootValue) {
        root = new Item<>(rootValue);
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
        Optional<Item<E>> root = findBy(parent);
        boolean result = false;
        if (root.isPresent()) {
            root.get().add(new Item<>(child));
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
    public Optional<Item<E>> findBy(E value) {
        Optional<Item<E>> rsl = Optional.empty();
        Queue<Item<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Item<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Item<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        Queue<Item<E>> data = new LinkedList<>();
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
                Item<E> el = data.poll();
                for (Item<E> child : Objects.requireNonNull(el).leaves()) {
                    data.offer(child);
                }
                return el.getValue();
            }
        };
    }

    @Override
    public void show(E value) {
        Optional<Item<E>> parent = findBy(value);
        boolean result = false;
        if (parent.isPresent()) {
            System.out.println(parent.get().getValue());
            parent.get().show(parent.get().getValue());
        }
    }

    @Override
    public String toString() {
        return (String) root.getValue();
    }
}

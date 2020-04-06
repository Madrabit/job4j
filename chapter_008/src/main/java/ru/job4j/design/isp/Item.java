package ru.job4j.design.isp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author madrabit
 * Menu Item.
 */
public class Item<E extends Comparable<E>> implements ShowMenu<E> {
    /**
     * Childrens of node.
     */
    private final List<Item<E>> children = new ArrayList<>();
    /**
     * Value.
     */
    private final E value;

    public Item(final E value) {
        this.value = value;
    }

    public void add(Item<E> child) {
        this.children.add(child);
    }

    public List<Item<E>> leaves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    public E getValue() {
        return value;
    }

    /**
     * Show leaves.
     * @param value Value.
     */
    @Override
    public void show(E value) {
        for (Item<E> leaf : children) {
            System.out.println(leaf.getValue());
            leaf.show(leaf.value);
        }
    }
}

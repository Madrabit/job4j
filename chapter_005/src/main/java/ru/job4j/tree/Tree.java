package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * @author madrabit on 06.11.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings({"unchecked", "ConstantConditions"})
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private final Node<E> root;

    public Tree(int rootValue) {
        root = (Node<E>) new Node<>(rootValue);
    }

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
        return null;
    }
}

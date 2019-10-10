package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author madrabit on 09.10.2019
 * @version 1$
 * @since 0.1
 */
public class DynamicArrayList<E> implements Iterable<E> {
    private int size;
    private DynamicArrayList.Node<E> head;
    private DynamicArrayList.Node<E> tail;
    private int modCount;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E data) {
        DynamicArrayList.Node<E> newLink = new DynamicArrayList.Node<>(data);
        newLink.next = this.head;
        newLink.next.prev = this.tail;
        this.head = newLink;
        this.size++;
        modCount++;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        DynamicArrayList.Node<E> result = this.head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return size > 0;
            }

            @Override
            public E next() {
                return this.next();
            }
        };
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {

        final E data;
        DynamicArrayList.Node<E> next;
        DynamicArrayList.Node<E> prev;

        Node(E data) {
            this.data = data;
        }
    }
}

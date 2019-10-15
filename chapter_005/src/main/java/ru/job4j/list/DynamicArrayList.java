package ru.job4j.list;

import java.util.*;

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
        if (head == null) {
            head = newLink;
            tail = newLink;
        } else {
            Node<E> oldLink = tail;
            oldLink.prev = newLink;
            tail = newLink;
        }
        this.size++;
        modCount++;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        DynamicArrayList.Node<E> result = this.head;

        for (int i = 0; i < index; i++) {
            result = result.prev;
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
        return new Iterator<>() {
            final int expectedModCount = modCount;
            int index = 0;
            DynamicArrayList.Node<E> currentNode = head;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return size > index;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                index++;
                E result;
                if (currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                return currentNode.data;
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

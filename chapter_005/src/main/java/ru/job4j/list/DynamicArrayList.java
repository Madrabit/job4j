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
        newLink.next = this.head;
        if (newLink.next != null) {
            newLink.prev = this.tail;
        }
        this.tail = newLink.next;
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
    public ListIterator<E> iterator() {
        return new ListIterator<E>() {
            int expectedModCount = modCount;
            int index = 0;
            DynamicArrayList.Node<E> result = head;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return size > index;
            }

            @Override
            public boolean hasPrevious() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index > 0;
            }

            @Override
            public E previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                index--;
                result = result.prev;
                return (E) result;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(E e) {

            }

            @Override
            public void add(E e) {

            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                index++;
                result = result.next;
                return (E) result.next;
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

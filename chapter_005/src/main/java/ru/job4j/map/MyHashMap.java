package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * My own HashMap realisation.
 *
 * @author madrabit on 28.10.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("UnusedReturnValue")
public class MyHashMap<K, V> implements Iterable<K> {
    /**
     * Hashtable.
     */
    private final Entry<K, V>[] table;
    /**
     * Current capacity.
     */
    private int capacity;
    /**
     * HashTable size.
     */
    private int size;

    /**
     * Modification for checking collection was not changed while iterate
     */
    private int modCount;

    /**
     * Head for starting iterate.
     */
    private MyHashMap.Entry<K, V> head;

    /**
     * Insert new object into HashMap.
     *
     * @param key   Key.
     * @param value Value.
     * @return Insert result.
     */
    public boolean insert(K key, V value) {
        int bucket = getBucket(key);
        Entry<K, V> current = table[bucket];
        Entry<K, V> entry = new Entry<>(key, value);
        boolean isHas = false;
        if (current == null) {
            table[bucket] = entry;
            checkSize();
            entry.next = this.head;
            this.head = entry;
            size++;
            isHas = true;
        } else {
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    current.next = this.head;
                    this.head = current;
                    isHas = true;
                    break;
                }
                current = current.next;
            }
        }
        modCount++;
        return isHas;
    }

    /**
     * Return object by key if exists.
     *
     * @param key Key.
     * @return Return object.
     */
    public V get(K key) {
        int bucket = getBucket(key);
        Entry<K, V> current = table[bucket];
        V result = null;
        while (current != null) {
            if (current.key.equals(key)) {
                result = current.value;
                break;
            }
            current = current.next;
        }
        return result;
    }

    /**
     * Delete object from HashMap.
     *
     * @param key Key.
     * @return Delete result.
     */
    boolean delete(K key) {
        int bucket = getBucket(key);
        Entry<K, V> previous = null;
        Entry<K, V> current = table[bucket];
        boolean result = false;
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[bucket] = table[bucket].next;
                } else {
                    current.prev = current.next;
                }
                result = true;
                size--;
                break;
            }
            previous = current;
            current = current.next;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        final int DEFAULT_CAPACITY = 16;
        table = new Entry[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            MyHashMap.Entry<K, V> current = head;

            final int expectedModCount = modCount;
            int index = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                index++;
                K result;
                if (current.next != null) {
                    current = current.next;
                }
                return current.key;
            }
        };
    }

    /**
     * One HashMap Entry.
     *
     * @param <K> Key.
     * @param <V> Value.
     */
    static class Entry<K, V> {
        final K key;
        private Entry<K, V> prev;
        V value;
        MyHashMap.Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public final K getKey() {
            return this.key;
        }

        public final V getValue() {
            return this.value;
        }

        public final V setValue(V newValue) {
            V oldValue = this.value;
            this.value = newValue;
            return oldValue;
        }
    }

    /**
     * Return bucket by key.
     *
     * @param key Key.
     * @return Bucket integer/index.
     */
    private int getBucket(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * Get Hashtable size.
     *
     * @return Size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Resizing HashTable if load factor more then 0.75.
     */
    private void checkSize() {
        if (size == capacity * 0.75) {
            capacity *= 2;
        }
    }
}

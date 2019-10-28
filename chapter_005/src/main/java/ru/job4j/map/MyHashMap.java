package ru.job4j.map;

/**
 * My own HashMap realisation.
 *
 * @author madrabit on 28.10.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("UnusedReturnValue")
public class MyHashMap<K, V> {
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
            size++;
            isHas = true;
        } else {
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    isHas = true;
                    break;
                }
                current = current.next;
            }
        }
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
        /**
         * Start capacity for HashMap.
         */
        int DEFAULT_CAPACITY = 16;
        table = new Entry[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
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
        final MyHashMap.Entry<K, V> next;

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

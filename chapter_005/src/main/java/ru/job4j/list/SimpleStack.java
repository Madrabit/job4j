package ru.job4j.list;

/**
 * Simple Stack implementation. LIFO.
 *
 * @author madrabit on 17.10.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings({"unchecked", "JavaDoc"})
public class SimpleStack<T> {
    /**
     * Container based on ArrayList.
     */
    final SimpleArrayList<T> container = new SimpleArrayList<>();

    /**
     * Delete and return Last add element.
     *
     * @param <T>
     * @return Last element of stack.
     */
    public <T> T poll() {
        return (T) container.delete();
    }

    /**
     * Add element to stack.
     *
     * @param value
     */
    public void push(T value) {
        container.add(value);
    }
}

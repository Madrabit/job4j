package ru.job4j.list;

/**
 * Simple Queue based on DynamicArrayList
 *
 * @author madrabit on 17.10.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("JavaDoc")
public class SimpleQueue<T> {
    /**
     * Container based on ArrayList.
     */
    final DynamicArrayList<T> container = new DynamicArrayList<>();

    /**
     * Delete and return First added element.
     *
     * @param <T>
     * @return First element of queue.
     */
    @SuppressWarnings({"unchecked", "TypeParameterHidesVisibleType"})
    public <T> T poll() {
        return (T) container.delete();
    }

    /**
     * Add element to queue.
     *
     * @param value
     */
    public void push(T value) {
        container.add(value);
    }
}

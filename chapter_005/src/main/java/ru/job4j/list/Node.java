package ru.job4j.list;

/**
 * Check cycle in LinkedList.
 *
 * @author madrabit on 18.10.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("rawtypes")
public class Node<T> {
    private int size;
    private Node<T> head;
    final T value;
    Node<T> next;

    public Node(T v) {
        value = v;
    }

    /**
     * The Tortoise and the Hare algorithm for checking cycle in linked list.
     *
     * @param head Start position in list.
     * @return Has cycle or not.
     */
    public static boolean hasCycle(Node head) {
        Node turtle = head;
        Node rabbit = head;
        boolean result = false;
        while (rabbit != null && rabbit.next != null) {
            rabbit = rabbit.next.next;
            turtle = turtle.next;
            if (rabbit == turtle) {
                result = true;
                break;
            }
        }
        return result;
    }
}

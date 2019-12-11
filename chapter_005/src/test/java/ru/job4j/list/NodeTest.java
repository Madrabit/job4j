package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit on 18.10.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class NodeTest {
    @Test
    public void whenLastNodeReferToLastNodeThenCycle() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        boolean result = Node.hasCycle(first);
        assertThat(result, is(true));
    }
}

package ru.job4j.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

/**
 * @author madrabit on 27.08.2019
 * @version 1$
 * @since 0.1
 */
public class SortUserTest {
    @Test
    public void when213then123() {
        SortUser sortUser = new SortUser();
        Set<SortUser.User> users = sortUser.sort(Arrays.asList(
                new SortUser.User("Ivan", 2),
                new SortUser.User("Petr", 1),
                new SortUser.User("Andrew", 3)
        ));
        String expected = "123";
        StringBuilder result = new StringBuilder();
        for (SortUser.User user : users) {
            result.append(user.getAge());
        }
        Assert.assertEquals(result.toString(), expected);
    }
}

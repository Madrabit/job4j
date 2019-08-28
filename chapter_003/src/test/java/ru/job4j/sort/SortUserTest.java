package ru.job4j.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
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

    @Test
    public void whenPetrYanAndrewthenYanPetrAndrew() {
        SortUser sortUser = new SortUser();
        List<SortUser.User> users = sortUser.sortNameLength(Arrays.asList(
                new SortUser.User("Petr", 2),
                new SortUser.User("Yan", 1),
                new SortUser.User("Andrew", 3)
        ));
        String expected = "YanPetrAndrew";
        StringBuilder result = new StringBuilder();
        for (SortUser.User user : users) {
            result.append(user.getName());
        }
        Assert.assertEquals(result.toString(), expected);
    }

    @Test
    public void whenPetr2Petr1Yan2Yan1thenYan1Yan2Petr1Petr2() {
        SortUser sortUser = new SortUser();
        List<SortUser.User> users = sortUser.sortByAllFields(Arrays.asList(
                new SortUser.User("Petr", 2),
                new SortUser.User("Petr", 1),
                new SortUser.User("Yan", 2),
                new SortUser.User("Yan", 1)
        ));
        String expected = "Yan1Yan2Petr1Petr2";
        StringBuilder result = new StringBuilder();
        for (SortUser.User user : users) {
            result.append(user.getName());
            result.append(user.getAge());
        }
        Assert.assertEquals(result.toString(), expected);
    }
}

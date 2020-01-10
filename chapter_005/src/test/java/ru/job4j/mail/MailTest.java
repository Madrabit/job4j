package ru.job4j.mail;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.*;

/**
 * @author madrabit on 20.11.2019
 * @version 1$
 * @since 0.1
 */
public class MailTest {
    @Test
    public void whenTwoSetsMergedShouldReturnTrue() {

        User user1 = new User(new ArrayList<>(List.of(
                "xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")),
                "user1"
        );
        User user2 = new User(new ArrayList<>(List.of(
                "foo@gmail.com", "ups@pisem.net")),
                "user2"
        );
        User user3 = new User(new ArrayList<>(List.of(
                "123123@gmail.com", "aaaa@pisem.net")),
                "user3"
        );
        List<User> users = new ArrayList<>(List.of(
                user1, user2, user3
        ));
        assertThat(Mail.join(users).toString(),
                is("[[123123@gmail.com, aaaa@pisem.net],"
                        + " [xxx@ya.ru, foo@gmail.com, lol@mail.ru, ups@pisem.net]]"));
    }
}

package ru.job4j.mail;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author madrabit on 20.11.2019
 * @version 1$
 * @since 0.1
 */
public class MailTest {
    @Test
    public void whenTwoSetsMergedShouldReturnTrue() {
        User user1 = new User(new HashSet<>(Arrays.asList(
                "xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        User user2 = new User(new HashSet<>(Arrays.asList(
                "foo@gmail.com", "ups@pisem.net")));
        Mail mail = new Mail();
        User result = mail.merge(user1, user2);
        assertThat(result.toString(), is("[ups@pisem.net, lol@mail.ru, xxx@ya.ru, foo@gmail.com]"));
    }


}

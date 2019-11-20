package ru.job4j.mail;

import java.util.Collections;

/**
 * @author madrabit on 20.11.2019
 * @version 1$
 * @since 0.1
 */
public class Mail<E> {
    public User<E> merge(User<E> first, User<E> second) {
        boolean result = false;
        if (!Collections.disjoint(first.getMails(), second.getMails())) {
            first.getMails().addAll(second.getMails());
        }
        return first;
    }
}

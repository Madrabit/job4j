package ru.job4j.mail;

import java.util.HashSet;
import java.util.Set;

/**
 * @author madrabit on 20.11.2019
 * @version 1$
 * @since 0.1
 */
public class User<E> {
    final HashSet<E> mails;

    public void addMail(E mail) {
        mails.add(mail);
    }

    public Set<E> getMails() {
        return mails;
    }

    public User(HashSet<E> mails) {
        this.mails = mails;
    }

    @Override
    public String toString() {
        return mails.toString();
    }
}

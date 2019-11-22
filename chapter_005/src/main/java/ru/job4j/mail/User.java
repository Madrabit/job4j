package ru.job4j.mail;

import java.util.List;

/**
 * @author madrabit on 20.11.2019
 * @version 1$
 * @since 0.1
 */
public class User {
    private final List<String> emails;
    private String name;

    public void addMail(List<String> mails) {
        emails.addAll(mails);
    }

    public List<String> getMails() {
        return emails;
    }

    public User(List<String> emails, String name) {
        this.emails = emails;
        this.name = name;
    }

    @Override
    public String toString() {
        return emails.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

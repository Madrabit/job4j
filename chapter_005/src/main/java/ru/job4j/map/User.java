package ru.job4j.map;

import java.util.Calendar;

/**
 * @author madrabit on 21.10.2019
 * @version 1$
 * @since 0.1
 */
public class User {
    private final String name;
    private final int children;
    @SuppressWarnings("FieldCanBeLocal")
    private final Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}

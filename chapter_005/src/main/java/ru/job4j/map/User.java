package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}

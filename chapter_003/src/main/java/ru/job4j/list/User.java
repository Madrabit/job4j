package ru.job4j.list;

/**
 * @author madrabit on 26.08.2019
 * @version 1$
 * @since 0.1
 */
public class User {
    public final Integer id;
    public final String name;
    public final String city;

    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}

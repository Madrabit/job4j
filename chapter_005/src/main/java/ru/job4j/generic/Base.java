package ru.job4j.generic;

/**
 * @author madrabit on 07.10.2019
 * @version 1$
 * @since 0.1
 */
public class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

package ru.job4j.di;

import java.util.ArrayList;
import java.util.List;

/**
 * @author madrabit on 14.09.2020
 * @version 1$
 * @since 0.1
 */
public class Store {
    private List<String> data = new ArrayList<String>();

    public void add(String value) {
        data.add(value);
    }

    public List<String> getAll() {
        return data;
    }
}

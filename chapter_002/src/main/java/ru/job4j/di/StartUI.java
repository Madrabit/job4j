package ru.job4j.di;

import org.springframework.stereotype.Component;

/**
 * @author madrabit on 14.09.2020
 * @version 1$
 * @since 0.1
 */
@Component
public class StartUI {
    private Store store;
    ConsoleInput input;

//    public StartUI(Store store) {
//        this.store = store;
//    }

    public StartUI(Store store, ConsoleInput input) {
        this.store = store;
        this.input =  input;
    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }

    public void ask(String question) {
        input.ask(question);
    }
}

package ru.job4j.design.lsp;

import java.util.List;

/**
 * @author madrabit
 */
public class Trash extends Storage {

    public Trash(List<Food> storage) {
        super(storage);
    }

}

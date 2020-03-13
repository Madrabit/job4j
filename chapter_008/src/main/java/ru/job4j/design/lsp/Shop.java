package ru.job4j.design.lsp;

import java.util.List;

/**
 * @author madrabit
 */
public class Shop extends Storage {

    public Shop(List<Food> storage) {
        super(storage);
    }

}

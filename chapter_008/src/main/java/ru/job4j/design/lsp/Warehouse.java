package ru.job4j.design.lsp;

import java.util.List;

/**
 * @author madrabit
 */
public class Warehouse extends Storage{

    public Warehouse(List<Food> storage) {
        super(storage);
    }

}

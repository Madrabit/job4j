package ru.job4j.design.lsp.storage;

import java.util.List;

/**
 * @author madrabit
 *  Storage Warehouse.
 *  Takes food wich freshness == percent < 25
 */
public class Warehouse extends Storage {

    public Warehouse(List<Food> storage) {
        super(storage);
    }

    @Override
    public boolean accept(Food food) {
        double percent = this.calcPercents(food);
        boolean result = false;
        if (percent < 25) {
            result = true;
        }
        return result;
    }

}

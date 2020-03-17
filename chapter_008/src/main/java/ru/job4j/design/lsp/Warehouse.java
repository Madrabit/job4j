package ru.job4j.design.lsp;

import java.util.List;

/**
 * @author madrabit
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

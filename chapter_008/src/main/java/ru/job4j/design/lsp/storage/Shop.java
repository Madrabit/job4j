package ru.job4j.design.lsp.storage;

import java.util.List;

/**
 * @author madrabit
 */
public class Shop extends Storage {

    public Shop(List<Food> storage) {
        super(storage);
    }

    @Override
    public boolean accept(Food food) {
        double percent = this.calcPercents(food);
        boolean result = false;
        if (percent >= 25 && percent < 75) {
            result = true;
        } else if (percent >= 75 && percent < 100) {
            food.discount();
            result = true;
        }
        return result;
    }
}

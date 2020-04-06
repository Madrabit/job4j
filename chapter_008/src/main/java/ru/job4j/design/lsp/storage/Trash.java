package ru.job4j.design.lsp.storage;

import java.util.List;

/**
 * @author madrabit
 *  Storage Trash.
 *  Takes food wich freshness == percent >= 100
 */
public class Trash extends Storage {

    public Trash(List<Food> storage) {
        super(storage);
    }

    @Override
    public boolean accept(Food food) {
        double percent = this.calcPercents(food);
        boolean result = false;
        if (percent >= 100) {
            result = true;
        }
        return result;
    }

}

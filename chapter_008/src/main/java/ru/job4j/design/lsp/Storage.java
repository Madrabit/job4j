package ru.job4j.design.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public abstract class Storage implements IStorage {
    private List<Food> storage;

    public Storage(List<Food> storage) {
        this.storage = storage;
    }

    public List<Food> getStorage() {
        return storage;
    }

    public void setStorage(List<Food> storage) {
        this.storage = storage;
    }

    protected double calcPercents(Food food) {
        final LocalDate current = LocalDate.of(2020, 3, 13);
        double all = ChronoUnit.DAYS.between(food.getExpiryDate(), food.getCreateDate());
        double passed = ChronoUnit.DAYS.between(current, food.getCreateDate());
        return passed / all * 100;
    }

    @Override
    public void add(Food f) {
            storage.add(f);
    }


}

package ru.job4j.design.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author madrabit
 */
public class ControlQuality {
    final Storage shop;
    final Storage warehouse;
    final Storage trash;

    //        LocalDate current = LocalDate.now();
    final LocalDate current = LocalDate.of(2020, 3, 13);

    public ControlQuality(Storage shop, Storage warehouse, Storage trash) {
        this.shop = shop;
        this.warehouse = warehouse;
        this.trash = trash;
    }

    public void distribute(Food food) {
        double all = ChronoUnit.DAYS.between(food.getExpiryDate(), food.getCreateDate());
        double passed = ChronoUnit.DAYS.between(current, food.getCreateDate());
        double percent = passed / all * 100;
        if (percent < 25) {
            warehouse.getStorage().add(food);
        } else if (percent >= 25 && percent < 75) {
            shop.getStorage().add(food);
        } else if (percent >= 75 && percent < 100) {
            food.discount();
            shop.getStorage().add(food);
        } else {
            trash.getStorage().add(food);
        }
    }
}

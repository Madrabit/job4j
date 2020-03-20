package ru.job4j.design.lsp;

import java.time.LocalDate;
import java.util.List;

/**
 * @author madrabit
 */
public class ControlQuality {
    final List<Storage> storageList;

    //        LocalDate current = LocalDate.now();
    final LocalDate current = LocalDate.of(2020, 3, 13);

    public ControlQuality(List<Storage> storageList) {
        this.storageList = storageList;
    }

    public void distribute(Food food) {
        for (Storage storage : storageList) {
            if (storage.accept(food)) {
                storage.add(food);
            }

        }
    }
}

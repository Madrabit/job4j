package ru.job4j.design.lsp.storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author madrabit
 * Food distribution.
 */
public class ControlQuality {
    /**
     * Storages.
     */
    final List<Storage> storageList;

    /**
     * Storage for clone.
     */
    List<Food> newStorage;

    /**
     * Current date.
     */
    //        LocalDate current = LocalDate.now();
    final LocalDate current = LocalDate.of(2020, 3, 13);

    public ControlQuality(List<Storage> storageList) {
        this.storageList = storageList;
    }

    /**
     * Food distribution.
     * @param food Input food.
     */
    public void distribute(Food food) {
        for (Storage storage : storageList) {
            storage.add(food);
        }
    }

    public List<Storage> getStorageList() {
        return storageList;
    }

    /**
     * Clear storage before resort.
     */
    private void clear() {
//        newStorage.addAll(getStorageList());
        newStorage = new ArrayList<>();
        for (Storage storage : storageList) {
            newStorage.addAll(storage.getStorage());
        }
    }

    /**
     * Clear and resort all food.
     */
    public void resort() {
        clear();
        for (Food food : newStorage) {
            distribute(food);
        }
    }
}

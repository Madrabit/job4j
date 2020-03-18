package ru.job4j.design.lsp.storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author madrabit
 */
public class ControlQuality {
    final List<Storage> storageList;
    List<Food> newStorage;

    //        LocalDate current = LocalDate.now();
    final LocalDate current = LocalDate.of(2020, 3, 13);

    public ControlQuality(List<Storage> storageList) {
        this.storageList = storageList;
    }

    public void distribute(Food food) {
        for (Storage storage : storageList) {
            storage.add(food);
        }
    }

    public List<Storage> getStorageList() {
        return storageList;
    }

    private void clear() {
//        newStorage.addAll(getStorageList());
        newStorage = new ArrayList<>();
        for (Storage storage : storageList) {
            newStorage.addAll(storage.getStorage());
        }
    }

    public void resort() {
        clear();
        for (Food food : newStorage) {
            distribute(food);
        }
    }
}

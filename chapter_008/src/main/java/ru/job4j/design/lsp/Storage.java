package ru.job4j.design.lsp;

import java.util.List;

public abstract class Storage {
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
}

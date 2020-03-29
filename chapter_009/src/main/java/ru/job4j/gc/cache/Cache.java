package ru.job4j.gc.cache;

import java.io.File;

public interface Cache {
    void add(String key, File file);

    String get(String key);
}

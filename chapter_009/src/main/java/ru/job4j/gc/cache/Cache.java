package ru.job4j.gc.cache;

import java.io.File;

public interface Cache {
    String get(File key);
}

package ru.job4j.gc.cache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class CacheTxt implements Cache {

    final Map<String, SoftReference<String>> map = new HashMap<>();

    private final File path;

    public CacheTxt(File path) {
        this.path = path;
    }

    @Override
    public String get(File key) {
        if (!map.containsKey(key.getName())) {
            putInMap(key);
        }
        String result = map.get(key.getName()).get();
        return result;
    }

    private void putInMap(File fileName) {
        String text = readFile(fileName);
        map.put(fileName.getName(), new SoftReference<>(text));

    }

    private String readFile(File fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = reader.readLine()) != null) {
                builder.append(s).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}

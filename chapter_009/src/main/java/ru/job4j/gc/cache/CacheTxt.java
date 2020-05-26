package ru.job4j.gc.cache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CacheTxt implements Cache {
    final Map<String, SoftReference<File>> map = new HashMap<>();

    @Override
    public void add(String key, File file) {
        // noinspection unchecked
        map.put(key, new SoftReference(file));
    }

    @Override
    public String get(String key) {
        File file = null;
        if (map.containsKey(key) && map.get(key) != null) {
            file = map.get(key).get();
        } else {
            file = new File(Objects.requireNonNull(CacheTxt.class.getClassLoader().getResource(key)).getFile());
            add(key, file);
        }
        return readFile(file);
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

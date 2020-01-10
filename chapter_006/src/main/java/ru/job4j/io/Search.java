package ru.job4j.io;

import java.io.File;
import java.util.*;

/**
 * Find and return List of files with a specific extension.
 *
 * @author madrabit on 27.11.2019
 * @version 1$
 * @since 0.1
 */
public class Search {
    /**
     * Find and return List of files with a specific extension.
     *
     * @param parent Directory where searching.
     * @param exts   List of extensions which want to find.
     * @return List of specific files.
     */
    public List<File> files(String parent, List<String> exts) {
        Queue<File> data = new LinkedList<>();
        List<File> list = new ArrayList<>();
        File file = new File(parent);
        data.offer(file);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (el.isDirectory()) {
                for (File listFile : Objects.requireNonNull(el.listFiles())) {
                    data.offer(listFile);
                }
            } else if (exts.stream().anyMatch(el.getName()::endsWith)) {
                list.add(el);
            }
        }
        return list;
    }

    public List<File> filesExcludeOne(String parent, String ext) {
        Queue<File> data = new LinkedList<>();
        List<File> list = new ArrayList<>();
        File file = new File(parent);
        data.offer(file);
        String cutExt = ext.replace("*", "");
        while (!data.isEmpty()) {
            File el = data.poll();
            if (el.isDirectory()) {
                for (File listFile : Objects.requireNonNull(el.listFiles())) {
                    data.offer(listFile);
                }
            }

            if (el.isFile() && !el.getName().endsWith(cutExt)) {
                list.add(el);
            }
        }
        return list;
    }
}



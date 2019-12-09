package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author madrabit on 27.11.2019
 * @version 1$
 * @since 0.1
 */
public class Zip {
    /**
     * Searching file.
     *
     * @param root Folder where start searching.
     * @param ext  File extension.
     * @return Searchable file.
     */
    List<File> seekBy(String root, String ext) {
        Search search = new Search();
        return search.filesExcludeOne(root, ext);
    }

    /**
     * Zip files.
     *
     * @param sources List of folders which want to zip.
     * @param target  Target zip file.
     */
    public void pack(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Args {
        private final Map<String, String> command = new HashMap<>();

        public Args(String[] args) {
            for (int i = 0; i < args.length; i += 2) {
                command.put(args[i], args[i + 1]);
            }
        }

        public String getDirectory() {
            return command.get("-d");
        }

        public String getExclude() {
            return command.get("-e");
        }

        public String getOutput() {
            return command.get("-o");
        }
    }

    public static void main(String[] args) {
        Zip.Args input = new Zip.Args(args);
        Zip zip = new Zip();
        zip.pack(zip.seekBy(input.getDirectory(), input.getExclude()), new File(input.getOutput()));
    }
}

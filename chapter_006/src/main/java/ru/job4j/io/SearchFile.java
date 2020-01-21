package ru.job4j.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * @author madrabit on 09.01.2020
 * @version 1$
 * @since 0.1
 */
public class SearchFile {
    File target = null;

    public void searchBy(String parent, Predicate<File> predicate) {
        Queue<File> data = new LinkedList<>();
        File file = new File(parent);
        data.offer(file);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (el.isDirectory()) {
                for (File listFile : Objects.requireNonNull(el.listFiles())) {
                    data.offer(listFile);
                }
            }
            if (el.isFile()) {
                if (predicate.test(el)) {
                    target = el;
                }

                if (target != null) {
                    break;
                }
            }
        }
    }

    public File search(String parent, String ext, Args params) {
        Predicate<File> f = i -> params.getByName() != null && ext.equals(i.getName());
        Predicate<File> m = i -> params.getByMask() != null && i.getName().endsWith(ext.replace("*", ""));
        Predicate<File> r = i -> params.getByRegexp() != null
                && Pattern.compile(ext).matcher(i.getName()).matches();

        searchBy(parent, f);
        searchBy(parent, m);
        searchBy(parent, r);
        return target;
    }

    public static class Args {
        private final Map<String, String> command = new HashMap<>();

        public Args(String[] args) {
            for (int i = 0; i < args.length; ) {
                if ("-m".equals(args[i])
                        || "-f".equals(args[i])
                        || "-r".equals(args[i])) {
                    command.put(args[i], args[i]);
                    i++;
                } else {
                    command.put(args[i], args[i + 1]);
                    i += 2;
                }
            }
        }

        public String getDirectory() {
            return command.get("-d");
        }

        public String getName() {
            return command.get("-n");
        }

        public String getByName() {
            return command.get("-f");
        }

        public String getByMask() {
            return command.get("-m");
        }

        public String getByRegexp() {
            return command.get("-r");
        }

        public String getOutput() {
            return command.get("-o");
        }
    }

    @SuppressWarnings("UnusedAssignment")
    public void writeResult(File file, String output) {
        String result = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            result = file.getName();
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SearchFile.Args input = new SearchFile.Args(args);
        SearchFile searchFile = new SearchFile();
        searchFile.writeResult(searchFile.search(input.getDirectory(), input.getName(), new SearchFile.Args(args)), input.getOutput());
    }
}

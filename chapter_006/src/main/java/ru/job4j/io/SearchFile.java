package ru.job4j.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author madrabit on 09.01.2020
 * @version 1$
 * @since 0.1
 */
public class SearchFile {
    public File searchByMask(String parent, String ext) {
        Queue<File> data = new LinkedList<>();
        File target = null;
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

            if (el.isFile() && el.getName().endsWith(cutExt)) {
                target = el;
                break;
            }
        }
        return target;
    }

    public File searchByName(String parent, String name) {
        Queue<File> data = new LinkedList<>();
        File target = null;
        File file = new File(parent);
        data.offer(file);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (el.isDirectory()) {
                for (File listFile : Objects.requireNonNull(el.listFiles())) {
                    data.offer(listFile);
                }
            }

            if (el.isFile() && name.equals(el.getName())) {
                target = el;
                break;
            }
        }
        return target;
    }

    public File searchByRegexp(String parent, String ext) {
        Queue<File> data = new LinkedList<>();
        File target = null;
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
                Pattern pattern = Pattern.compile(ext);
                Matcher exc = pattern.matcher(el.getName());
                if (exc.matches()) {
                    target = el;
                    break;
                }
            }

        }
        return target;
    }

    public File search(String parent, String target, String f, String m, String r) {
        File file = null;
        if (f != null) {
            file = searchByName(parent, target);
        } else if (m != null) {
            file = searchByMask(parent, target);
        } else if (r != null) {
            file = searchByRegexp(parent, target);
        }
        return file;
    }


    public static class Args {
        private final Map<String, String> command = new HashMap<>();

        public Args(String[] args) {
            for (int i = 0; i < args.length;) {
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
        searchFile.writeResult(searchFile.search(input.getDirectory(), input.getName(), input.getByName(), input.getByMask(), input.getByRegexp()), input.getOutput());
    }
}

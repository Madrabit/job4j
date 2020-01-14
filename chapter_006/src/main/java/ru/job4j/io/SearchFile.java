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
    File target = null;

    public File searchBy(String parent, String ext, Args params) {
        Queue<File> data = new LinkedList<>();
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

            if (el.isFile()) {
                searchByCriteria(el, ext, params);
                if (target != null) {
                    break;
                }
            }
        }
        return target;
    }

    public void searchByCriteria(File el, String ext, Args params) {
        String f = params.getByName();
        String m = params.getByMask();
        String r = params.getByRegexp();

        String cutExt = ext.replace("*", "");
        if (f != null && ext.equals(el.getName())) {
            target = el;
        } else if (m != null && el.getName().endsWith(cutExt)) {
            target = el;
        } else if (r != null) {
            Pattern pattern = Pattern.compile(ext);
            Matcher exc = pattern.matcher(el.getName());
            if (exc.matches()) {
                target = el;
            }
        }
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
        searchFile.writeResult(searchFile.searchBy(input.getDirectory(), input.getName(), new SearchFile.Args(args)), input.getOutput());
    }
}

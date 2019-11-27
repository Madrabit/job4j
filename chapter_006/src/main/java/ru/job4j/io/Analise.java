package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author madrabit on 25.11.2019
 * @version 1
 * @since 0.1
 */
public class Analise {

    /**
     * Write to List periods when server was unreachable.
     *
     * @param source Log file.
     * @param target File with results.
     */
    public List<String> unavailable(String source, String target) {
        List<String> times = new LinkedList<>();
        ReaderLog readerLog = new ReaderLog(source);
        readerLog.load();
        boolean flag = false;
        StringBuilder record = new StringBuilder();
        for (Map.Entry<Integer, String> entry : readerLog.values.entrySet()) {
            if (entry.getKey() >= 400 && !flag) {
                record = new StringBuilder(String.format("%s;", entry.getValue()));
                flag = true;
            } else if (entry.getKey() < 400) {
                record.append(String.format("%s;", entry.getValue()));
                times.add(record.toString());
                record = new StringBuilder();
                flag = false;
            }
        }
        return times;
    }

    /**
     * Write to file periods when server was unreachable.
     *
     * @param source Log file.
     * @param target File with results.
     */
    public void writeLog(String source, String target) {
        List<String> log = this.unavailable(source, target);
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (String s : log) {
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Load logs inner class
     */
    public static class ReaderLog {
        final Map<Integer, String> values = new HashMap<>();
        private final String path;

        public ReaderLog(String path) {
            this.path = path;
        }

        public void load() {
            StringJoiner out = new StringJoiner(System.lineSeparator());
            try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
                read.lines().forEach(
                        s -> {
                            String[] reg = s.split(" ");
                            values.put(Integer.parseInt(reg[0]), reg[1]);
                        }
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

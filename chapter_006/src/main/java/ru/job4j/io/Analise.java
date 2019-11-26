package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @author madrabit on 25.11.2019
 * @version 1
 * @since 0.1
 */
public class Analise {

    /**
     * Write to file period when server was unreachable.
     *
     * @param source Log file.
     * @param target File with results.
     */
    public void unavailable(String source, String target) {
        ReaderLog readerLog = new ReaderLog(source);
        readerLog.load();
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            boolean flag = false;
            for (Map.Entry<Integer, String> entry : readerLog.values.entrySet()) {
                if (entry.getKey() >= 400 && !flag) {
                    out.println(entry.getValue());
                    flag = true;
                } else if (entry.getKey() < 400) {
                    out.println(entry.getValue());
                    flag = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
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

package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * @author madrabit on 28.11.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("ConstantConditions")
public class Chat {
    public static class Bot {
        private final String path;

        public Bot(String path) {
            this.path = path;
        }

        public String load() {
            try (RandomAccessFile file = new RandomAccessFile(path, "r")) {
                int pos = (int) (Math.random() * file.length());
                file.seek(pos);
                return file.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = "";
        String path = System.getProperty("user.dir") + "/chapter_006/data/pair_without_comment.properties";
        String target = System.getProperty("user.dir") + "/chapter_006/data/chat.log";
        Chat.Bot bot = new Chat.Bot(path);
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            while (!text.equals("exit")) {
                text = in.nextLine();
                System.out.println(text);
                out.println(text);
                if (text.equals("exit")) {
                    break;
                }
                //noinspection ConstantConditions
                if (!text.equals("stop") || text.equals("continue")) {
                    String answer = bot.load();
                    System.out.println(answer);
                    out.println(answer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

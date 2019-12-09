package ru.job4j.io;

import java.io.*;
import java.util.Scanner;

/**
 * @author madrabit on 28.11.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("ConstantConditions")
public class Chat {
    public static class Bot {
        private RandomAccessFile file;

        public Bot(String path) {
            try {
                file = new RandomAccessFile(path, "r");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String load() throws IOException {
            int pos = (int) (Math.random() * file.length());
            file.seek(pos);
            return file.readLine();
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
                    bot.file.close();
                    out.close();
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

package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author madrabit on 28.11.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("ConstantConditions")
public class Chat {
    public static class Bot {
        private List<String> botText;
        private final String pathToFile;

        public Bot(String path) {
            pathToFile = path;
            getBotText();
        }

        private void getBotText() {
            try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
                botText = reader.lines().collect(Collectors.toList());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String getPhrase() {
            int pos = (int) (Math.random() * botText.size());
            return botText.get(pos);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = "";
        String path = System.getProperty("user.dir") + "/chapter_006/data/server.log";
        String target = System.getProperty("user.dir") + "/chapter_006/data/chat.log";
        Chat.Bot bot = new Chat.Bot(path);
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            while (!"exit".equals(text)) {
                text = in.nextLine();
                System.out.println(text);
                out.println(text);
                if (!"stop".equals(text) || "continue".equals(text)) {
                    String answer = bot.getPhrase();
                    System.out.println(answer);
                    out.println(answer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

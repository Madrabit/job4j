package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Используется для ввода пользовательских данных из консоли.
 * @author madrabit on 29.07.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("DuplicatedCode")
public class ConsoleInput implements Input  {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.next();
    }

    @Override
    public int ask(String question, int[] range)  {
        int key = Integer.parseInt(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }
}

package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Используется для ввода пользовательских данных из консоли.
 * @author madrabit on 29.07.2019
 * @version 1$
 * @since 0.1
 */
public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.next();
    }
}

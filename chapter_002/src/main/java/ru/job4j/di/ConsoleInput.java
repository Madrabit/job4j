package ru.job4j.di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.job4j.tracker.MenuOutException;

import java.util.List;
import java.util.Scanner;

/**
 * Используется для ввода пользовательских данных из консоли.
 * @author madrabit on 29.07.2019
 * @version 1$
 * @since 0.1
 */

@Component
@Scope("prototype")
public class ConsoleInput  {
    private final Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.next();
    }

    public int ask(String question, List<Integer> range)  {
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

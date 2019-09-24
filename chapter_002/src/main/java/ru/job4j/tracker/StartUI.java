package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Точка входа в программу.
 * @author madrabit on 29.07.2019
 * @version 1$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для показа всех заявок.
     */
    private static final String FINDALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по Id.
     */
    private static final String FINDBYID = "4";
    /**
     * Константа меню для поиска зявки по названию.
     */
    private static final String FINDBYNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Consumer
     */
    private final Consumer<String> output;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     * @param output
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основой цикл программы.
     */
    public void init()  {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, System.out::println);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("select:", range));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Запускт программы.
     * @param args args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}

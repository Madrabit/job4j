package ru.job4j.di;

/**
 * @author madrabit on 14.09.2020
 * @version 1$
 * @since 0.1
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);

        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.ask("How old are u?");
        ui.print();
    }
}

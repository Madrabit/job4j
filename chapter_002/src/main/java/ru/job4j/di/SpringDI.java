package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author madrabit on 14.09.2020
 * @version 1$
 * @since 0.1
 */
public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j.di");
        context.refresh();
        StartUI ui1 = context.getBean(StartUI.class);
        StartUI ui2 = context.getBean(StartUI.class);
        System.out.println(ui1 != ui2 ? "protorype" : "singleton");
//        ui.add("Petr Arsentev");
//        ui.add("Ivan ivanov");
//        ui.ask("Where are u?");
//        ui.print();
    }
}

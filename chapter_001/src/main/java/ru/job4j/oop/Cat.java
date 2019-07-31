package ru.job4j.oop;

/**
 * @author madrabit on 31.07.2019
 * @version 1$
 * @since 0.1
 */
public class Cat {
    private String food;
    private String name;

    /**
     * Выводит данные об объекте на консоль
     */
    public void show() {
        System.out.println(this.name + " : " + this.food);
    }

    /**
     * Добавляет в поле вид еды, который ест кот.
     * @param meat Вид еды.
     */
    public void eat(String meat) {
        this.food = meat;
    }

    /**
     * Добавляет имя животному.
     * @param nick Кличка животного.
     */
    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}

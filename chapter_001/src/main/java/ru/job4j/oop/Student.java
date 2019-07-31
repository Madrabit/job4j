package ru.job4j.oop;

/**
 * @author madrabit on 31.07.2019
 * @version 1$
 * @since 0.1
 */
public class Student {
    /**
     * Выводит на консоль "музыку"
     */
    public void music() {
        System.out.println("Tra tra tra");
    }

    /**
     * Метод "петь" песню
     */
    public void song() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();
    }
}

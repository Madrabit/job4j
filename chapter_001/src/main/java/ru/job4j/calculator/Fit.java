package ru.job4j.calculator;

public class Fit {
    /**
     * Методы индекса массы тела мужчины.
     * @param height Рост
     * @return Индек массы тела
     */
    public static double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Методы индекса массы тела женщины.
     * @param height Рост
     * @return Индек массы тела
     */
    public static double womanWeight(double height) {
        return (height - 110) * 1.15;
    }

    /**
     * Main
     * @param args args
     */
    public static void main(String[] args) {
        double man = manWeight(180);
        System.out.println("Man 180 is " + man);

        double woman = womanWeight(160);
        System.out.printf("Woman 160 is %.1f", woman);
    }
}

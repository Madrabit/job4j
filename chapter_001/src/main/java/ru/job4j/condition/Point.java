package ru.job4j.condition;

/**
 * Класс вычисления расстояния между точками в системе координат.
 */

public class Point {

    /**
     * метод вычисления расстояния между точками.
     * @param x1 x1
     * @param y1 y1
     * @param x2 x2
     * @param y2 y2
     * @return расстояние
     */
    public static double distance(int x1, int y1, int x2, int y2) {

        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static void main(String[] args) {
        double result = distance(0, 0, 2, 0);
        System.out.println("result (0, 0) to (2, 0) " + result);

        result = distance(1, 4, 4, 5);
        System.out.println("result (0, 0) to (2, 0) " + result);

        result = distance(10, 10, 20, 20);
        System.out.println("result (0, 0) to (2, 0) " + result);
    }
}

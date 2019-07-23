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
    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}

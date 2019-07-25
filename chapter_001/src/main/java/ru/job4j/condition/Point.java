package ru.job4j.condition;

/**
 * Класс вычисления расстояния между точками в системе координат.
 */
public class Point {
    /**
     * X - точки
     */
    private int x;
    /**
     * Y - точки
     */
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * метод вычисления расстояния между точками.
     * @param that точка.
     * @return расстояние
     */
    public double distance(Point that) {
        return Math.sqrt(Math.pow((this.x - that.x), 2) + Math.pow((this.y - that.y), 2));
    }

    /**
     * Вывод координат точки
     */
    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
}

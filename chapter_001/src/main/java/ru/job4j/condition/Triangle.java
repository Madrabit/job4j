package ru.job4j.condition;

/**
 * Вычисление площади треугольника
 * @author madrabit
 * @version $Id$
 * @since 1
 */

public class Triangle {
    /**
     * Координаты точек треугольника
     */
    private Point first;
    private Point second;
    private Point third;

    /**
     * Конструктор треугольника
     * @param ap точка a
     * @param bp точка b
     * @param cp точка c
     */
    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }
    /**
     * Метод вычисления полупериметра по длинам сторон.
     *
     * Формула.
     *
     * (a + b + c) / 2
     *
     * @param a расстояние между точками a b
     * @param b расстояние между точками a c
     * @param c расстояние между точками b c
     * @return полупериметр.
     */
    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * Каждая сторона должна быть меньше суммы двух других
     * @param a Длина от точки a b.
     * @param b Длина от точки a c.
     * @param c Длина от точки b c.
     * @return Существует ли треугольник
     */
    private boolean exist(double a, double c, double b) {
        return a < b + c && b < a + c && c < a + b;
    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * Формула.
     *
     * √ p *(p - a) * (p - b) * (p - c)
     *
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * @return Вернуть площадь, если треугольник существует или -1.
     */
    public double area() {
        double rsl = -1;
        double a = first.distance(second);
        double b = first.distance(third);
        double c = second.distance(third);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return rsl;
    }
}

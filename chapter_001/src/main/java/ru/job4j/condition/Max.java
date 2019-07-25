package ru.job4j.condition;

/**
 * Класс вычисления максимального числа
 * @author madrabit
 * @version $Id$
 * @since 0.1
 */

public class Max {

    /**
     * Метод вычисления максимального числа из 2
     * @param a Первое число
     * @param b Второе число
     * @return Максимальное число
     */
    public int max(int a, int b) {
        return a >= b ? a : b;
    }

    /**
     * Метод вычисления максимального числа из 3
     * @param a Первое число
     * @param b Второе число
     * @param c Третье число
     * @return Максимальное число
     */
    public int max(int a, int b, int c) {
        a = a >= b ? a : b;
        return  a >= c ? a : c;
    }

    /**
     * Метод вычисления максимального числа из 4
     * @param a Первое число
     * @param b Второе число
     * @param c Третье число
     * @param d Четвертое число
     * @return Максимальное число
     */
    public int max(int a, int b, int c, int d) {
        a = a >= b ? a : b;
        a = a >= c ? a : c;
        return  a >= d ? a : d;
    }
}

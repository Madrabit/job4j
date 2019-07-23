package ru.job4j.loop;

/**
 * Программа вычисляющая факториал.
 * @author  madrabit
 * @version $Id$
 * @since 1
 */

public class Factorial {
    /**
     * Метод вычисления факториала через цикл for.
     * @param n Вычисляемое число.
     * @return Факториал.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

package ru.job4j.condition;

/**
 * Класс вычисления максимального числа
 * @author madrabit
 * @version $Id$
 * @since 0.1
 */

public class Max {

    /**
     * Метод вычисления максимального числа
     * @param left Первое число
     * @param right Второе число
     * @return Максимальное число
     */
    public int max(int left, int right) {
        return left >= right ? left : right;
    }
}

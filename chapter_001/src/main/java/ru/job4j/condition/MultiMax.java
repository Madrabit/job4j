package ru.job4j.condition;

/**
 * Класс показывающий максимум из 3-х чисел
 * @author madrabit
 * @version $Id$
 * @since 1
 */
@SuppressWarnings("ALL")
public class MultiMax {
    /**
     * Вычисление макисмума
     * @param first первое число
     * @param second второе число
     * @param third третье число
     * @return максимальное из трех
     */
    public int max(int first, int second, int third) {
        int result = first >= second ? first : second;
        return result >= third ? result : third;
    }
}

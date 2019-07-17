package ru.job4j.loop;

/**
 * Подсчет суммы чётных чисел в диапазоне[#159100]
 * @author madrabit
 * @version $id$
 * @since 1
 */
public class Counter {
    /**
     * Сумматор четных чисел в диапозоне
     * @param start стартовое число
     * @param finish конечное число
     * @return сумма четных чисел
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}

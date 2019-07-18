package ru.job4j.loop;

/**
 * Простые числа
 * @author madrabit
 * @version $Id$
 * @since 1
 */
public class PrimeNumber {
    /**
     * Метод вычисляет Простые числа (считается, число которое делится только на себя и на единицу).
     * @param finish Число до которого нужно найти все "простые" числа
     * @return возращает количество простых чисел
     */
    public int calc(int finish) {
        int count = 0;
        for (int i = 2; i <= finish; i++) {
            for (int j = 2; j <= i; j++) {
                if ((i != j) && ((i % j) == 0)) {
                    break;
                } else if (i == j) {
                    count++;
                }
            }
        }
        return count;
    }
}

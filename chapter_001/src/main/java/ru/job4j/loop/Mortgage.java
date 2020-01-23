package ru.job4j.loop;

/**
 * Ипотека
 * @author madrabit
 * @version $Id$
 * @since 1
 */
public class Mortgage {
    /**
     *  Метод должен вычислять количество лет необходимых для погашения кредита.
     * @param amount сумма выданная по кредиту
     * @param monthly ежемесячный платеж
     * @param percent процентная ставка по кредиту
     * @return количество лет необходимых для погашения кредита
     */
    public int year(int amount, int monthly, double percent) {
        int year = 1;
        percent = amount * (int) percent / 100;
        amount += percent;
        int month = 0;
        while (amount >= 0) {
            amount -= monthly;
            month++;
            if (month == 12) {
                year++;
                month = 1;
            }
        }
        return year;
    }
}

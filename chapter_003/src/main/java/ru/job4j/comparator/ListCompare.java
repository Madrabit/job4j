package ru.job4j.comparator;

import java.util.Comparator;

/**
 * Компаратор для строк.
 * @author madrabit on 28.08.2019
 * @version 1$
 * @since 0.1
 */
public class ListCompare implements Comparator<String> {
    /**
     * Сравнение двух строк без String.compareTo
     * @param left Первая строка.
     * @param right Вторая срока.
     * @return Результат сравнения строк.
     */
    @Override
    public int compare(String left, String right) {
        int len = Math.min(left.length(), right.length());
        int comp = 0;
        if (left.length() == right.length()) {
            for (int i = 0; i < left.length(); i++) {
                comp += Character.compare(left.charAt(i), right.charAt(i));
            }
        } else {
            for (int i = 0; i < len; i++) {
                comp += Character.compare(left.charAt(i), right.charAt(i));
                if (comp == 0 && i == len - 1) {
                    comp = left.length() > right.length() ? 1 : -1;
                }
            }
        }
        return comp;
    }
}

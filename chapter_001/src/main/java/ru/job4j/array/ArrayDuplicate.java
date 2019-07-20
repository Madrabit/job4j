package ru.job4j.array;

import java.util.Arrays;

/**
 * 6.8. Удаление дубликатов в массиве.[#159115]
 * @author madrabit on 20.07.19
 * @version 1$
 * @since 0.1
 */
public class ArrayDuplicate {
    /**
     * Удаляет дубликаты из массива строк.
     * @param array Массив с дубликатами
     * @return Массив без дубликотов.
     */
    public String[] remove(String[] array) {
        int counter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length - counter; j++) {
                if (array[i].equals(array[j])) {
                    String temp = array[array.length - (1 + counter)];
                    array[array.length - (1 + counter)] = array[j];
                    array[j] = temp;
                    counter++;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, array.length - counter);
    }
}

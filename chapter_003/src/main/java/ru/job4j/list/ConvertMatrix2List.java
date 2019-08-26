package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Конвертация двумерного массива в ArrayList.
 * @author madrabit on 23.08.2019
 * @version 1$
 * @since 0.1
 */
public class ConvertMatrix2List {
    /**
     * Метод конвертации двумерного массива в ArrayList.
     * @param array Вводимый двумерный массив.
     * @return Возвращаемая коллекция.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] ints : array) {
            for (int anInt : ints) {
                list.add(anInt);
            }
        }
        return list;
    }
}

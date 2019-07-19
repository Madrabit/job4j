package ru.job4j.array;

/**
 *  Перевернуть массив.[#159117]
 *  @author madrabit on 19.07.19
 * @version 1$
 * @since 0.1
 */
public class Turn {
    /**
     * Метоод разворачивает массив.
     * @param array Исходный массив.
     * @return Перевернутый массив.
     */
    public int[] back(int[] array) {
        int temp;
        for (int  i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - (1 + i)];
            array[array.length - (1 + i)] = temp;
        }
        return array;
    }
}

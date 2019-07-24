package ru.job4j.array;

/**
 * @author madrabit on 24.07.19
 * @version 1$
 * @since 0.1
 */
public class CheckIsSorted {
    /**
     * Проверка, отсортирован ли массив. (По возрастранию).
     * @param arr Проверяемый массив.
     * @return Результат проверки.
     */
    public boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

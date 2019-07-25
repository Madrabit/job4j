package ru.job4j.array;

/**
 * Объединить два массива
 * @author madrabit on 22.07.19
 * @version 1$
 * @since 0.1
 */
public class Merge {
    /**
     * Слияние двух отсортерованных массивов.
     * @param left первый массив
     * @param right второй массив
     * @return Объеденный отсортерованный массив.
     */
    public int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                merged[k] = left[i];
                i++;
            } else {
                merged[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            merged[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            merged[k] = right[j];
            j++;
            k++;
        }
        return merged;
    }
}

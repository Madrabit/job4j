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
        int[] smallest = left[0] < right[0] ? left : right;
        int[] biggest = left[0] > right[0] ? left : right;
        for (int i = 0, j = 0; i < merged.length; i++) {
            if (i < smallest.length) {
                merged[i] = smallest[i];
            } else {
                merged[i] = biggest[j];
                j++;
            }
        }
        return merged;
    }
}

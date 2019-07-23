package ru.job4j.array;

/**
 * Объединить два массива
 * @author madrabit on 22.07.19
 * @version 1$
 * @since 0.1
 */
public class Merge {
    public int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int[] smallest = left[0] < right[0] ? left : right;
        int[] biggest = left[0] > right[0] ? left : right;
        System.arraycopy(smallest, 0,  merged, 0, smallest.length);
        System.arraycopy(biggest, 0,  merged, smallest.length, biggest.length);
        return merged;
    }
}

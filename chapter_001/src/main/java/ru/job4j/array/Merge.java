package ru.job4j.array;

/**
 * Объединить два массива
 * @author madrabit on 22.07.19
 * @version 1$
 * @since 0.1
 */
public class Merge {
    public int[] merge(int[] left, int[] right) {
        int arrayLength = left.length + right.length;
        int[] merged = new int[arrayLength];

        for(int i = 0; i < merged.length; i++) {

            if (i < left.length) {
                if(left[i] < right[i]) {

                    merged[i] = left[i];

                } else {
                    merged[i] = right[i];
                }
            } else {
                if(left[i - left.length] < right[i - left.length]) {

                    merged[i] = right[i - left.length];

                } else {
                    merged[i] = left[i -left.length];
                }
            }

        }


        return merged;
    }
}

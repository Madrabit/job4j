package ru.job4j.finaltask;

import java.util.Arrays;

/**
 * Final Task Stream
 */
public class Finaltask {
    /**
     * Method filter by odd, then pow 2, sum numbers in the end
     * @param arr Integer array
     * @return Int
     */
    public Integer convert(int[] arr) {
     return Arrays.stream(arr)
                .filter(e -> e % 2 == 0)
                .map(e -> (int) Math.pow(e, 2))
                .sum();
    }
}

package ru.job4j.coffemaker;

import java.util.Arrays;

/**
 * @author madrabit on 15.08.2019
 * @version 1$
 * @since 0.1
 */
public class Coffeemaker {

    private int[] arrayGenerator(int[]array) {
        return Arrays.copyOf(array, array.length + 1);
    }

    public int[] changes(int value, int price) {
        if (value - price == 0) {
            return new int[]{0};
        }
        int delta = value - price;
        int[] change = new int[0];
        int i = 0;
        while (delta > 0) {
            if (delta == 10 || delta / 10 >= 1) {
                int num = (int) Math.floor(delta / 10);
                delta = delta - num * 10;
                change = arrayGenerator(change);
                change[i] = num * 10;
            } else if (delta % 10 >= 5) {
                delta -= 5;
                change = arrayGenerator(change);
                change[i] = 5;
            } else if (delta % 10 >= 2) {
                delta -= 2;
                change = arrayGenerator(change);
                change[i] = 2;
            } else if (delta % 10 == 1) {
                delta -= 1;
                change = arrayGenerator(change);
                change[i] = 1;
            }
            i++;
        }
        return change;
    }
}

package ru.job4j.coffemaker;

/**
 * @author madrabit on 15.08.2019
 * @version 1$
 * @since 0.1
 */
public class Coffeemaker {   

    public int[] changes(int value, int price) {
        if (value - price == 0) {
            return new int[]{0};
        }
        int delta = value - price;
        int[] change = new int[delta];
        int coin = 0;
        int[] coins = new int[]{10, 5, 2, 1};
        for (int item : coins) {
            while (delta >= item) {
                delta -= item;
                change[coin++] = item;
            }
        }
        int[] backchange = new int[coin];
        System.arraycopy(change, 0, backchange, 0, coin);
        return backchange;
    }
}

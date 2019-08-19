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
        int coin = 0;
        int ten = 0, five = 0, two = 0, one = 0;
        while (delta > 0) {
            if (delta == 10 || delta / 10 >= 1) {
                int num = (int) Math.floor(delta / 10);
                delta = delta - num * 10;
                ten++;
            } else if (delta % 10 >= 5) {
                delta -= 5;
                five++;
            } else if (delta % 10 >= 2) {
                delta -= 2;
                two++;
            } else if (delta % 10 == 1) {
                delta -= 1;
                one++;
            }
            coin++;
        }
        int[] coins = new int[]{ten, five, two, one};
        int[] change = new int[coin];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < coins[i]; j++) {
                if (i == 0) {
                    change[i] = 10;
                } else if (i == 1) {
                    change[i] = 5;
                } else if (i == 2) {
                    change[i] = 2;
                } else {
                    change[i] = 1;
                }
            }
        }
        return change;
    }
}

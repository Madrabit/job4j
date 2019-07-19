package ru.job4j.array;

/**
 *
 * @author madrabit on 19.07.19
 * @version 1$
 * @since 0.1
 */
public class Square {
    /**
     * Заполняет массив числами, возведенными в квадрат.
     * @param bound Число, до которого заполнять.
     * @return Массив чисел возведенных в квадрат.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];

        for (int i = 0; i < rst.length; i++) {
            rst[i] = (int) Math.pow(i + 1, 2);
        }

        return rst;
    }
}

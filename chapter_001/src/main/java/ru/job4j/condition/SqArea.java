package ru.job4j.condition;

/**
 * Класс вычисления площади прямоугольника.
 */

public class SqArea {
    /**
     * Метод вычисления площади.
     * @param p периметр
     * @param k во сколько раз ширина больше высоты
     * @return площадь
     */
    public static int square(int p, int k) {
        int w =  p / 2 * k / (k + 1);
        int h = w / k;

        return w * h;
    }

    /**
     * Main
     * @param args args
     */

    public static void main(String[] args) {
        int result1 = square(6, 2);
        System.out.println(" p = 4, k = 1, s = 2, real = " + result1);
    }
}

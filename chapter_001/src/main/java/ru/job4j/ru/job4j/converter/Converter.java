package ru.job4j.ru.job4j.converter;

/**
 * Class Конвертер валют.
 */

public class Converter {

    /**
     * Конвертер рубли в евро.
     * @param value Рубли
     * @return Евро
     */
    public static int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертер рубли в доллары.
     * @param value Рубли
     * @return Доллары
     */

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Конвертер доллары в рубли.
     * @param value Доллары
     * @return Рубли
     */

    public static int dollarToRuble(int value) {
        return value * 60;
    }

    /**
     * Конвертер евро в рубли.
     * @param value Евро
     * @return Рубли
     */
    public static int euroToRuble(int value) {
        return value * 70;
    }

    /**
     * Main
     * @param args args
     */

    public static void main(String[] args) {
        int euro = rubleToEuro(140);
        int dollar = rubleToDollar(140);
        int rubleFromEu = euroToRuble(140);
        int rubleFromDl = dollarToRuble(140);

        System.out.println("140 rubles are " + euro + " euro.");
        System.out.println("140 rubles are " + dollar + " dollars.");
        System.out.println("140 euro are " + rubleFromEu + " rubles.");
        System.out.println("140 dollars are " + rubleFromDl  + " rubles.");
    }
}

package ru.job4j.array;

/**
 * Массив заполнен true или false[#159112].
 * @author madrabit on 19.07.19
 * @version 1$
 * @since 0.1
 */
public class Check {
    /**
     * Метод должен проверить, что все элементы в массиве являются true или false.
     * @param data Проверяемый массив.
     * @return Результат проеврки.
     */
    public boolean mono(boolean[] data) {
        boolean flag = data[0];
        for (int i = 1; i < data.length; i++) {
            if (flag != data[i]) {
                return false;
            }
        }
        return true;
    }
}

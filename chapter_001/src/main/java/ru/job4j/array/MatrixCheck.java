package ru.job4j.array;

/**
 * Квадратный массив заполнен true или false по диагоналям.[#159113]
 * @author madrabit on 19.07.19
 * @version 1$
 * @since 0.1
 */
public class MatrixCheck {
    /**
     * Метод должен проверить, что все элементы по диагоналям равны true или false.
     * @param data Проверяемый массив.
     * @return Результат проверки.
     */
    public boolean mono(boolean[][] data) {


        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1]) {
                return false;
            }
            if (data[i][data.length - (1 + i)] != data[i + 1][data.length - (2 + i)]) {
                return false;
            }
        }

        return true;
    }
}

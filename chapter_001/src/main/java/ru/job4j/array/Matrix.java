package ru.job4j.array;

/**
 * Двухмерный массив. Таблица умножения.[#159110]
 * @author madrabit on 19.07.19
 * @version 1$
 * @since 0.1
 */
public class Matrix {
    /**
     * Генерация таблицы умножения
     * @param size Размер таблицы.
     * @return Созданная таблица умножения ввиде матрицы.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];

        for (int i = 0, k = 1; i < size; i++, k++) {
            for (int j = 0, z = 1; j < size; j++, z++) {
                table[i][j] = z * k;
            }
        }
        return table;
    }

}

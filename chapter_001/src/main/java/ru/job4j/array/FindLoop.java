package ru.job4j.array;

/**
 * Классический поиск перебором.[#159109]
 * @author madrabit on 19.07.19
 * @version 1$
 * @since 0.1
 */
public class FindLoop {
    /**
     * Последовательный перебору каждого элемента.
     * Если элемент подходит под условие, мы останавливаем цикл.
     * @param data массив чисел
     * @param el искомы элемент
     * @return индекс элемента
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }

    /**
     * Поиск индекса в диапазоне.
     * @param data Массив чисел.
     * @param el Искомый элемент.
     * @param start Начальная позиция поиска.
     * @param finish Конечная позиция поиска.
     * @return Индекс искомого элемента.
     */
    public int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1;
        for (int i = start; i < finish; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}

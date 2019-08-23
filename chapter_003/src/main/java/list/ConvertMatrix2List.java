package list;

import java.util.ArrayList;
import java.util.List;

/**
 * Конвертация двумерного массива в ArrayList
 * @author madrabit on 23.08.2019
 * @version 1$
 * @since 0.1
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int count2 = 0;
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (count2 == array[count].length - 1) {
                    list.add(array[count][count2]);
                    count2 = 0;
                    break;
                }
                list.add(array[count][count2++]);
            }
            count++;
        }
        return list;
    }
}

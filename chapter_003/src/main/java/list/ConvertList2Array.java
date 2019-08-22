package list;

import java.util.Iterator;
import java.util.List;

/**
 * @author madrabit on 22.08.2019
 * @version 1$
 * @since 0.1
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        Iterator iterator = list.iterator();
        int count = 0;
        int count2 = 0;
        for (int[] el : array) {
            for (int i : el) {
                if (iterator.hasNext()) {
                    array[count][count2++] = (int) iterator.next();
                }
            }
            count2 = 0;
            count++;
        }
        return array;
    }
}

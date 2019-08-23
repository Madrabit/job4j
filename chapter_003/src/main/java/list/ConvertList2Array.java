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
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int count = 0;
        int count2 = 0;
        for (Integer integer : list) {
            if (count2 == 3) {
                count++;
                count2 = 0;
            }
            array[count][count2++] = integer;
        }
        return array;
    }
}

package list;

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
        int counter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (counter >= list.size()) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = list.get(counter);
                }
                counter++;
            }
        }

        for (int[] ints : array) {
            for (int anInt : ints) {

            }
            for (Integer integer : list) {
                
            }
        }
        
        return array;
    }
}

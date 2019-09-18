package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Converting Integer Matrix to List of Integers
 * @author madrabit on 18.09.2019
 * @version 1$
 * @since 0.1
 */
public class MatrixToInteger {
    /**
     * Converting Integer Matrix to List of Integers with using flatMap
     * @param matrix
     * @return List of Integers
     */
    public List<Integer> convertMatrixToInt(List<List<Integer>> matrix) {
        return matrix.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
    }

}

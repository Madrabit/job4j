package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Converting Integer Matrix to List of Integers
 * @author madrabit on 18.09.2019
 * @version 1$
 * @since 0.1
 */
public class MatrixToInteger {
    /**
     * Converting Integer Matrix to List of Integers with using flatMap
     * @param matrix Input matrix.
     * @return List of Integers
     */
    public List<Integer> convertMatrixToInt(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList());
    }
}

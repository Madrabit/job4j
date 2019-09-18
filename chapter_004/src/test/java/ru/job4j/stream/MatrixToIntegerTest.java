package ru.job4j.stream;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author madrabit on 18.09.2019
 * @version 1$
 * @since 0.1
 */
public class MatrixToIntegerTest {
    @Test
    public void whenMatrixThenInt() {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        MatrixToInteger obj = new MatrixToInteger();
        List<Integer> result = obj.convertMatrixToInt(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(result, is(expected));
    }
}

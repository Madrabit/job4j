package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Range counter.
 * @author madrabit on 12.09.2019
 * @version 1$
 * @since 0.1
 */
public class Diapason {
    /**
     * Range counting method.
     * @param start Range start.
     * @param end Range finish
     * @param func Lambda function.
     * @return Range of diapason return in a list.
     */
    public List<Double> diapason(int start, int end, Function<Integer, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i != end; i++) {
            list.add(func.apply(i));
        }
        return list;
    }
}

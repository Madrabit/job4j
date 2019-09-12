package ru.job4j.lambda;

import org.junit.Test;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * @author madrabit on 12.09.2019
 * @version 1$
 * @since 0.1
 */
public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> (double) (2 * x + 1));
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Diapason function = new Diapason();
        List<Double> result =  function.diapason(5, 8, x -> 2 * Math.pow(x, 2) + 2 * x + 2);
        List<Double> expected = Arrays.asList(62D, 86D, 114D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Diapason function = new Diapason();
        List<Double> result =  function.diapason(5, 8, Math::log);
        List<Double> expected = Arrays.asList(1.6094379124341003, 1.791759469228055, 1.9459101490553132);
        assertThat(result, is(expected));
    }
 }

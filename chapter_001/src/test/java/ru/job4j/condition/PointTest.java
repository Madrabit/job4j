package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;


/**
 * @author madrabit
 * @version $Id$
 * @since 1
 */

public class PointTest {
    @Test
    public void whenPoints0020Then2() {
        Point point = new Point();
        double result = point.distance(0, 0, 2, 0);
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }

    @Test
    public void whenPoints1445Then3() {
        Point point = new Point();
        double result = point.distance(1, 4, 4, 5);
        double expected = 3.1D;
        assertThat(result, closeTo(expected, 0.1));
    }
}

package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit on 30.07.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("StringBufferReplaceableByString")
public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                        .append("++++")
                        .append(System.getProperty("line.separator"))
                        .append("+  +")
                        .append(System.getProperty("line.separator"))
                        .append("+  +")
                        .append(System.getProperty("line.separator"))
                        .append("++++")
                        .toString()
                )
        );
    }
}

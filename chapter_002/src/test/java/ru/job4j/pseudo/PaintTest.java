package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author madrabit on 30.07.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("StringBufferReplaceableByString")
public class PaintTest {
    final PrintStream stdout = System.out;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(out));

    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append(System.getProperty("line.separator"))
                                .append("+  +")
                                .append(System.getProperty("line.separator"))
                                .append("+  +")
                                .append(System.getProperty("line.separator"))
                                .append("++++")
                                .append(System.getProperty("line.separator"))
                                .toString()
                )
        );

    }
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                            .append("--+--")
                            .append(System.getProperty("line.separator"))
                            .append("-+-+-")
                            .append(System.getProperty("line.separator"))
                            .append("+---+")
                            .append(System.getProperty("line.separator"))
                                .toString()
                )
        );
    }
}

package io;

import org.junit.Test;
import ru.job4j.io.Analise;

/**
 * @author madrabit on 26.11.2019
 * @version 1$
 * @since 0.1
 */
public class AnaliseTest {
    @Test
    public void whenPairWithoutComment() {
        String source = "./data/server.log";
        String target = "./data/unavailable.csv";

        Analise analise = new Analise();
        analise.unavailable(source, target);
    }
}

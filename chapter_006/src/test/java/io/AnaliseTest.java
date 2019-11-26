package io;

import org.junit.Test;
import ru.job4j.io.Analise;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author madrabit on 26.11.2019
 * @version 1$
 * @since 0.1
 */
public class AnaliseTest {
    @Test
    public void whenUnavailableShouldReturn1058to1102() {
        String source = "./data/server.log";
        String target = "./data/unavailable.csv";

        Analise analise = new Analise();
        List<String> result = analise.unavailable(source, target);
        assertThat(
                result.get(0),
                is("10:58:01;11:02:02;")
        );
    }

    @Test
    public void whenWriteLogShouldFeelFile() {
        String source = "./data/server.log";
        String target = "./data/unavailable.csv";
        Analise analise = new Analise();
        analise.writeLog(source, target);
    }
}

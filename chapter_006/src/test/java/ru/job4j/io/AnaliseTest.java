package ru.job4j.io;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.io.Analise;

import java.io.File;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author madrabit on 26.11.2019
 * @version 1$
 * @since 0.1
 */
public class AnaliseTest {
    @Ignore
    @Test
    public void whenUnavailableShouldReturn1058to1102() {
        String source = String.format(".%sdata%sserver.log", File.separator, File.separator);
        String target = "./data/unavailable.csv";

        Analise analise = new Analise();
        List<String> result = analise.unavailable(source, target);
        assertThat(
                result.get(0),
                is("10:58:01;11:02:02;")
        );
    }
    @Ignore
    @Test
    public void whenWriteLogShouldFeelFile() {
        String source = String.format(".%sdata%sserver.log", File.separator, File.separator);
        String target = "./data/unavailable.csv";
        Analise analise = new Analise();
        analise.writeLog(source, target);
    }
}

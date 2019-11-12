package ru.job4j.analyzer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit on 12.11.2019
 * @version 1$
 * @since 0.1
 */
public class AnalyzerTest {
    @Test
    public void whenAdd1ShouldReturn1() {
        List<Analyzer.User> previous = new ArrayList<>(List.of(
                new Analyzer.User(1, "Ivan"),
                new Analyzer.User(2, "Petr")
        ));
        List<Analyzer.User> current = new ArrayList<>(List.of(
                new Analyzer.User(1, "Ivan"),
                new Analyzer.User(2, "Petr"),
                new Analyzer.User(3, "Alex")
        ));
        Analyzer analyzer = new Analyzer();
        Analyzer.Info result = analyzer.diff(previous, current);
        assertThat(result.getAdded(), is(1));
    }

    @Test
    public void whenDelete2ShouldReturn1() {
        List<Analyzer.User> previous = new ArrayList<>(List.of(
                new Analyzer.User(1, "Ivan"),
                new Analyzer.User(2, "Petr"),
                new Analyzer.User(3, "Alex")
        ));
        List<Analyzer.User> current = new ArrayList<>(List.of(
                new Analyzer.User(1, "Ivan")
        ));
        Analyzer analyzer = new Analyzer();
        Analyzer.Info result = analyzer.diff(previous, current);
        assertThat(result.getDeleted(), is(2));
    }

    @Test
    public void whenChanged2ShouldReturn2() {
        List<Analyzer.User> previous = new ArrayList<>(List.of(
                new Analyzer.User(1, "Ivan"),
                new Analyzer.User(2, "Petr"),
                new Analyzer.User(3, "Alex")
        ));
        List<Analyzer.User> current = new ArrayList<>(List.of(
                new Analyzer.User(1, "Ivan"),
                new Analyzer.User(2, "Vova"),
                new Analyzer.User(3, "Serg")
        ));
        Analyzer analyzer = new Analyzer();
        Analyzer.Info result = analyzer.diff(previous, current);
        assertThat(result.getChanged(), is(2));
    }
}

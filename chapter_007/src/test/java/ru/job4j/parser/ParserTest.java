package ru.job4j.parser;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit
 */
public class ParserTest {
    private DataBase base;

    @Before
    public void initBase() {
        base = new DataBase();
        base.init();
    }

    @Test
    public void checkConnection() {
        assertThat(base.init(), is(true));
    }

//    @Test
//    public void parser() {
//        Parser parser = new Parser();
//
//        parser.parse();
//
//        base.add(parser.getVacancySet());
//
//    }
//
//    @Test
//    public void testParserUpdater() {
//        Parser parser = new Parser();
//
//        parser.update();
//
//        base.update(parser.getVacancySet());
//
//    }
}

package io;

import org.junit.Test;
import ru.job4j.io.Search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author madrabit on 27.11.2019
 * @version 1$
 * @since 0.1
 */
public class SearchTest {
    @Test
    public void whenPairWithoutComment() {
//        String path = System.getProperty("java.io.tmpdir") + File.separator;
        String path = "./data/";

        List<String> ext = new LinkedList<>(Arrays.asList("log", "csv"));
        Search search = new Search();
        List result = search.files(path, ext);
        assertEquals(
                result.toString(),
                "[./data/unavailable.csv, ./data/server.log]"
        );
    }
}

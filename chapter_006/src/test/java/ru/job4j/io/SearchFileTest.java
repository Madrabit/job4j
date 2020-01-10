package ru.job4j.io;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * @author madrabit on 09.01.2020
 * @version 1$
 * @since 0.1
 */
public class SearchFileTest {
    @Test
    public void whenSearchingByMaskShouldChatLog() {
        String path = "./data/";
        SearchFile search = new SearchFile();
        File result = search.searchByMask(path, "*.log");
        assertEquals(
                result.toString(),
                "./data/chat.log"
        );
    }
    @Test
    public void whenSearchByNameShouldServerLog() {
        String path = "./data/";
        SearchFile search = new SearchFile();
        File result = search.searchByName(path, "server.log");
        assertEquals(
                result.toString(),
                "./data/server.log"
        );
    }

    @Test
    public void whenSearchByRegexpShouldChatLog() {
        String path = "./data/";
        SearchFile search = new SearchFile();
        File result = search.searchByRegexp(path, ".*log.*");
        assertEquals(
                result.toString(),
                "./data/chat.log"
        );
    }
}

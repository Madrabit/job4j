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
        SearchFile.Args params = new SearchFile.Args(new String[]{"-d", "/home/madrabit/Documents/projects/job4j", "-n", "*.log", "-m", "-o", "null"});
        SearchFile searchFile = new SearchFile();
        File result = search.searchBy(path, "*.log", params);
        assertEquals(
                result.toString(),
                "./data/chat.log"
        );
    }

    @Test
    public void whenSearchByNameShouldServerLog() {
        String path = "./data/";
        SearchFile search = new SearchFile();
        SearchFile.Args params = new SearchFile.Args(new String[]{"-d", "/home/madrabit/Documents/projects/job4j", "-n", "*.log", "-f", "-o", "null"});
        File result = search.searchBy(path, "server.log", params);
        assertEquals(
                result.toString(),
                "./data/server.log"
        );
    }

    @Test
    public void whenSearchByRegexpShouldChatLog() {
        String path = "./data/";
        SearchFile search = new SearchFile();
        SearchFile.Args params = new SearchFile.Args(new String[]{"-d", "/home/madrabit/Documents/projects/job4j", "-n", "*.log", "-r", "-o", "null"});
        File result = search.searchBy(path, ".*log.*", params);
        assertEquals(
                result.toString(),
                "./data/chat.log"
        );
    }
}

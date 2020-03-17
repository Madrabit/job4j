package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static org.junit.Assert.assertEquals;

/**
 * @author madrabit on 09.01.2020
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public class SearchFileTest {
    private File root;

    @Before
    public void createFilesStructure() throws FileNotFoundException {
        File tmp = new File(System.getProperty("java.io.tmpdir"));
        root = new File(tmp, "root");
        File dir = new File(root, "dir");
        root.mkdir();
        dir.mkdirs();
        new FileOutputStream(dir.getPath() + "/chat.log");
        new FileOutputStream(dir.getPath() + "/test.csv");
        new FileOutputStream(dir.getPath() + "/server.log");
    }

    @Test
    public void whenSearchingByMaskShouldChatLog() {
        SearchFile search = new SearchFile();
        SearchFile.Args params = new SearchFile.Args(new String[]{"-d", root.getAbsolutePath(), "-n", "*.log", "-m", "-o", "null"});
        SearchFile searchFile = new SearchFile();
        File result = search.search(root.getAbsolutePath(), "*.log", params);
        assertEquals(
                result.toString(),
                "/tmp/root/dir/chat.log"
        );
    }

    @Test
    public void whenSearchByNameShouldServerLog() {
        SearchFile search = new SearchFile();
        SearchFile.Args params = new SearchFile.Args(new String[]{"-d", root.getAbsolutePath(), "-n", "*.log", "-f", "-o", "null"});
        File result = search.search(root.getAbsolutePath(), "server.log", params);
        assertEquals(
                result.toString(),
                "/tmp/root/dir/server.log"
        );
    }

    @Test
    public void whenSearchByRegexpShouldChatLog() {
        SearchFile search = new SearchFile();
        SearchFile.Args params = new SearchFile.Args(new String[]{"-d", root.getAbsolutePath(), "-n", "*.log", "-r", "-o", "null"});
        File result = search.search(root.getAbsolutePath(), ".*log.*", params);
        assertEquals(
                result.toString(),
                "/tmp/root/dir/chat.log"
        );
    }
}

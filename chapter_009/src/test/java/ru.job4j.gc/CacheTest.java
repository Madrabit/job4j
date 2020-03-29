package ru.job4j.gc;

import org.junit.Test;
import ru.job4j.gc.cache.Cache;
import ru.job4j.gc.cache.CacheTxt;

import java.io.File;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class CacheTest {
    @Test
    public void whenAddTxtThenReturnText() {
        Cache cache = new CacheTxt();
        File file = new File(Objects.requireNonNull(CacheTest.class.getClassLoader().getResource("test.txt")).getFile());
        cache.add("test.txt", file);
        String result = cache.get("test.txt");
        assertEquals(result, "Hello World!\n");

    }

    @Test
    public void whenNoFileInCacheAddEndReturnIt() {
        CacheTxt cache = new CacheTxt();
        String result = cache.get("some.txt");
        assertEquals(result, "get some\n");

    }
}

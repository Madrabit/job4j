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
        File file = new File(Objects.requireNonNull(CacheTest.class.getClassLoader().getResource("test.txt").getPath()));
        Cache cache = new CacheTxt(file);
        String result = cache.get(file);
        assertEquals(result, "Hello World!\n");

    }

    @Test
    public void whenNoFileInCacheAddEndReturnIt() {
        File file = new File(Objects.requireNonNull(CacheTest.class.getClassLoader().getResource("test.txt")).getPath());
        File someText = new File(Objects.requireNonNull(CacheTest.class.getClassLoader().getResource("some.txt")).getPath());
        Cache cache = new CacheTxt(file);
        String result = cache.get(someText);
        assertEquals(result, "get some\n");

    }
}

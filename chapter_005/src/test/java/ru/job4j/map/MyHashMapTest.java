package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author madrabit on 28.10.2019
 * @version 1$
 * @since 0.1
 */
public class MyHashMapTest {

    @Test
    public void whenInsertTwoSameKeysShouldNotChangeSize() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.insert("Key1", "Value1");
        map.insert("Key1", "Value2");
        assertThat(map.getSize(), is(1));
    }

    @Test
    public void whenInsertTwoSameKeysShouldChangeValue() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.insert("Key1", "Value1");
        map.insert("Key1", "Value2");
        assertEquals(map.get("Key1"), "Value2");
    }

    @Test
    public void whenAddTwoValuesThenReturnValue2ByKey() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.insert("Key1", "Value1");
        map.insert("Key2", "Value2");
        assertEquals(map.get("Key2"), "Value2");
    }

    @Test
    public void whenDeleteKey2ShouldReturnTrue() {
        MyHashMap<String, String> map = new MyHashMap<>();
        for (int i = 0; i < 16; i++) {
            map.insert(String.format("Key%s", i), String.format("Value%s", i));
        }
        map.insert("Key13", "Value13");
        assertThat(map.getSize(), is(13));
    }

    @Test
    public void whenGetNextThen1() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.insert("Key1", "Value1");
        map.insert("Key2", "Value2");
        Iterator<String> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertEquals(it.next(), "Key1");
    }


}

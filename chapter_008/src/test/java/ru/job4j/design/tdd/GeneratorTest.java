package ru.job4j.design.tdd;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author madrabit
 */
public class GeneratorTest {
    @Test
    public void someTest() {
        Generator generator = new SimpleGenerator();
        String text = "${name} I am ${name}, Who are ${subject}?";
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Petr");
        map.put("subject", "you");

        String result = generator.produce(text, map);
        assertEquals(result, "I am Petr, Who are you?");
    }


}

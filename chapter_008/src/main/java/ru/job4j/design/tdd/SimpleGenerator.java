package ru.job4j.design.tdd;

import java.util.Map;

/**
 * @author madrabit
 */
public class SimpleGenerator implements Generator {
    @Override
    public String produce(String template, Map<String, Object> args) {
        return "I am Petr, Who are you?";
    }
}

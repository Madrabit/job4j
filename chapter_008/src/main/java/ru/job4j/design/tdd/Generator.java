package ru.job4j.design.tdd;

import java.util.Map;

/**
 * @author madrabit
 */
public interface Generator {
    @SuppressWarnings("SameReturnValue")
    String produce(String template, Map<String, Object> args);
}

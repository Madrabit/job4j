package ru.job4j.tracker;

import java.util.List;

/**
 * @author madrabit on 29.07.2019
 * @version 1$
 * @since 0.1
 */
public interface Input {
    String ask(String question);
    int ask(String question, List<Integer> range);
}

package ru.job4j.search;

/**
 * Класс "задания" с приоритетами
 * @author madrabit on 22.08.2019
 * @version 1$
 * @since 0.1
 */
public class Task {
    /**
     * Описание задания
     */
    private final String desc;
    /**
     * Приоритет задания
     */
    private final int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}

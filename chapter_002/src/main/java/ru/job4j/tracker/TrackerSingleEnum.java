package ru.job4j.tracker;

/**
 * @author madrabit on 07.08.2019
 * @version 1$
 * @since 0.1
 */
public enum TrackerSingleEnum {
    INSTANCE;

    public Item add(Item model) {
        return model;
    }
}

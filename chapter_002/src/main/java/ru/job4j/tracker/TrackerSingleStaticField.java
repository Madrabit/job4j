package ru.job4j.tracker;

/**
 * @author madrabit on 07.08.2019
 * @version 1$
 * @since 0.1
 */
public class TrackerSingleStaticField {
    private static TrackerSingleStaticField instance;

    public TrackerSingleStaticField() {
    }

    public static TrackerSingleStaticField getInstance() {
        if (instance == null) {
            instance = new TrackerSingleStaticField();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }
}

package ru.job4j.tracker;

/**
 * @author madrabit on 07.08.2019
 * @version 1$
 * @since 0.1
 */
public class TrackerSingleStaticFinalField {
    private static final TrackerSingleStaticFinalField INSTANCE = new TrackerSingleStaticFinalField();

    public TrackerSingleStaticFinalField() {
    }

    public static TrackerSingleStaticFinalField getInstance() {
        return INSTANCE;
    }
}

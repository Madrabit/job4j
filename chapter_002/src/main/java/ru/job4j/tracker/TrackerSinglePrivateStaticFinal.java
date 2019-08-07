package ru.job4j.tracker;

/**
 * @author madrabit on 07.08.2019
 * @version 1$
 * @since 0.1
 */
public class TrackerSinglePrivateStaticFinal {
    public TrackerSinglePrivateStaticFinal() {
    }

    public static TrackerSinglePrivateStaticFinal getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSinglePrivateStaticFinal INSTANCE = new TrackerSinglePrivateStaticFinal();
    }
}

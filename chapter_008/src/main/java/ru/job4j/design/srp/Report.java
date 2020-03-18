package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * @author madrabit
 */
@SuppressWarnings("StringBufferReplaceableByString")
public abstract class Report implements IReport {
    private final Store store;

    public Store getStore() {
        return store;
    }

    public Report(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        //noinspection MismatchedQueryAndUpdateOfStringBuilder
        StringBuilder text = new StringBuilder();
        return text.toString();
    }
}

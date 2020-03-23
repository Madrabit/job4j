package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * @author madrabit
 */
public class ReportJson extends Report {
    public ReportJson(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        return null;
    }
}

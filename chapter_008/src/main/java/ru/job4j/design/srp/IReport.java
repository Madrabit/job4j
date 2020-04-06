package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * Report Interface.
 */
public interface IReport {
    String generate(Predicate<Employer> filter);
}

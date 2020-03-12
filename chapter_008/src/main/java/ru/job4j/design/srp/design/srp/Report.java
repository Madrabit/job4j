package ru.job4j.design.srp.design.srp;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employer> filter);
}

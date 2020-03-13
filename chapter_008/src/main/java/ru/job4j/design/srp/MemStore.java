package ru.job4j.design.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author madrabit
 */
public class MemStore implements Store {

    private final List<Employer> employers = new ArrayList<>();

    public void add(Employer em) {
        employers.add(em);
    }

    public List<Employer> getEmployers() {
        return employers;
    }

    @Override
    public List<Employer> findBy(Predicate<Employer> filter) {
        return employers.stream().filter(filter).collect(Collectors.toList());
    }
}

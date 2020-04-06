package ru.job4j.design.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author madrabit
 * Employee storage realisation.
 */
public class MemStore implements Store {

    /**
     * List of Employee.
     */
    private final List<Employer> employers = new ArrayList<>();

    /**
     * Add to storage.
     * @param em
     */
    public void add(Employer em) {
        employers.add(em);
    }

        public List<Employer> getEmployers() {
        return employers;
    }

    /**
     * Find in storage with filter.
     * @param filter Predicate.
     * @retur New list.
     */
    @Override
    public List<Employer> findBy(Predicate<Employer> filter) {
        return employers.stream().filter(filter).collect(Collectors.toList());
    }
}

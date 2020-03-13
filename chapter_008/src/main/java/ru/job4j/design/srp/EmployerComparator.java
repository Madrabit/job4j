package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.List;

/**
 * @author madrabit
 */
public class EmployerComparator {
    public static void sortSalaryReversed(List<Employer> list) {
        list.sort(
                Comparator.comparingInt(employer -> (int) -employer.getSalary())
        );
    }
}

package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.List;

/**
 * @author madrabit
 * Class for sroting employeree.
 */
public class EmployerComparator {
    /**
     * Reverse sort by salary.
     * @param list Employee.
     */
    public static void sortSalaryReversed(List<Employer> list) {
        list.sort(
                Comparator.comparingInt(employer -> (int) -employer.getSalary())
        );
    }
}

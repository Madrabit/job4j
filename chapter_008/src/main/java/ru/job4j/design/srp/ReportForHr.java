package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * @author madrabit
 * Report for HR.
 * Revers Sorted by salary.
 */
public class ReportForHr extends Report {
    private final MemStore store;

    public ReportForHr(Store store) {
        super(store);
        this.store = (MemStore) store;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        EmployerComparator.sortSalaryReversed(store.getEmployers());
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";");
        }
        return text.toString();
    }


}



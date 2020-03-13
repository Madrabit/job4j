package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * @author madrabit
 */
public class ReportForAccountant {
    private final Store store;

    public ReportForAccountant(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary() * 72).append(" руб.").append(";");
        }
        return text.toString();
    }
}

package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * @author madrabit
 */
public class ReportForAccountant extends Report {

    public ReportForAccountant(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employer employer : getStore().findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary() * 72).append(" руб.").append(";");
        }
        return text.toString();
    }
}

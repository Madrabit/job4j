package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * @author madrabit
 * Report for It.
 * HTML template.
 */
public class ReportForIt extends Report {


    public ReportForIt(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>"
                + "<body>"
                + "<div>"
                + "<table>"
        );

        text.append("<thead>"
                + "<tr>"
                + "<td>Name</td>"
                + "<td>Hired</td>"
                + "<td>Fired</td>"
                + "<td>Salary</td>"
                + "</tr>"
                + "</thead>"
                + "<tbody>"
        );
        for (Employer employer : getStore().findBy(filter)) {
            text.append("<tr>");
            text.append("<td>").append(employer.getName()).append("</td>");
            text.append("<td>").append(employer.getSalary()).append("руб.</td>");
            text.append("</tr>");
        }
        text.append("</tbody>"
                + "</table>"
                + "</div>"
                + "</body>"
                + "</html>");
        return text.toString();
    }
}

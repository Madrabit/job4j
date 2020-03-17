package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.design.srp.design.srp.*;

import java.util.Calendar;

/**
 * @author madrabit
 */
public class ReportTest {

    @Test
    public void whenGenerateForIt() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportForIt engine = new ReportForIt(store);
        String expect = "<html><body><div><table><thead><tr><td>Name</td><td>Hired</td><td>Fired</td><td>Salary</td></tr></thead><tbody><tr><td>Ivan</td><td>100.0руб.</td></tr></tbody></table></div></body></html>";
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenGenerateForAccountant() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportForAccountant engine = new ReportForAccountant(store);
        //noinspection StringBufferReplaceableByString
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() * 72).append(" руб.").append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGenerateForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        Employer worker1 = new Employer("Sergay", now, now, 200);
        Employer worker2 = new Employer("Andrew", now, now, 300);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        ReportForHr engine = new ReportForHr(store);
        //noinspection StringBufferReplaceableByString
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}

package ru.job4j.design.srp;

import java.util.Calendar;
import java.util.Objects;

/**
 * @author madrabit
 */
public class Employer {
    private String name;
    private Calendar hired;
    private Calendar fired;
    private double salary;

    public Employer(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getHired() {
        return hired;
    }

    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    public Calendar getFired() {
        return fired;
    }

    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employer employer = (Employer) o;
        return Double.compare(employer.salary, salary) == 0
                && Objects.equals(name, employer.name)
                && Objects.equals(hired, employer.hired)
                && Objects.equals(fired, employer.fired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hired, fired, salary);
    }


}

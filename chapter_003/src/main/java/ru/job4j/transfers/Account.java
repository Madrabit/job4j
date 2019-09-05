package ru.job4j.transfers;

import java.util.Objects;

/**
 * @author madrabit on 04.09.2019
 * @version 1$
 * @since 0.1
 */
public class Account {
    private double value;
    private int requisites;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getRequisites() {
        return requisites;
    }

    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
         }
        Account account = (Account) o;
        return requisites == account.requisites;
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }
}

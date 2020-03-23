package ru.job4j.design.tdd.cinema;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author madrabit
 */
public class Cinema3D implements Cinema {
    List<Session> sessions = null;

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    @Override
    public void add(Session session) {

    }

    @Override
    public List<Session> getSessions() {
        return null;
    }
}

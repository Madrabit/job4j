package ru.job4j.design.tdd.cinema;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 */
@SuppressWarnings("EmptyMethod")
public interface Cinema {
    /**
     * Find session and return it.
     * @param filter Predicate for filter.
     * @return session.
     */
    List<Session> find(Predicate<Session> filter);

    /**
     * Buy ticket.
     * @param account client.
     * @param row row.
     * @param column column.
     * @param date date.
     * @return ticket
     */
    Ticket buy(Account account, int row, int column, Calendar date);

    /**
     * Add session to cinema.
     * @param session
     */
    void add(Session session);

    List getSessions();
}

package ru.job4j.chess.firuges;

/**
 * @author madrabit on 09.08.2019
 * @version 1$
 * @since 0.1
 */
public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String message) {
        super(message);
    }
}

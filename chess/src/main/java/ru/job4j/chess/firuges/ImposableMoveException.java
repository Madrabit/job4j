package ru.job4j.chess.firuges;

/**
 * @author madrabit on 08.08.2019
 * @version 1$
 * @since 0.1
 */
public class ImposableMoveException extends RuntimeException {
    public ImposableMoveException(String message) {
        super(message);
    }
}

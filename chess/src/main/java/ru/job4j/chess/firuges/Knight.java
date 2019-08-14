package ru.job4j.chess.firuges;

/**
 * @author madrabit on 14.08.2019
 * @version 1$
 * @since 0.1
 */
public abstract class Knight implements Figure {
    private final Cell position;

    public Knight(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaY = source.y - dest.y;
        int deltaX = source.x - dest.x;
        boolean direction = Math.abs(deltaX) - Math.abs(deltaY) > 0 ? true : false;
        if (
                (direction && !(Math.abs(deltaX) == 2 && Math.abs(deltaY) == 1))
                        || (!direction && !(Math.abs(deltaX) == 1 && Math.abs(deltaY) == 2))
        )
        {
            throw new ImposableMoveException("Ход невозможен");
        }
        return new Cell[] { dest };
    }
}

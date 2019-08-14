package ru.job4j.chess.firuges;

/**
 * @author madrabit on 14.08.2019
 * @version 1$
 * @since 0.1
 */
public abstract class King implements Figure{
    private final Cell position;

    public King(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[1];
        int deltaY = source.y - dest.y;
        int deltaX = source.x - dest.x;
        if (Math.abs(deltaX) > 1 || Math.abs(deltaY) > 1) {
            throw new ImposableMoveException("Ход невозможен");
        }
        steps[0] = dest ;
        return steps;
    }
}

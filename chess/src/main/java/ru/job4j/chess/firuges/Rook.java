package ru.job4j.chess.firuges;

/**
 * @author madrabit on 14.08.2019
 * @version 1$
 * @since 0.1
 */
public abstract class Rook implements Figure{
    private final Cell position;

    public Rook(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        if (Math.abs(deltaX) == Math.abs(deltaY)) {
            return true;
        }
        return false;
    }
    @Override
    public Cell[] way(Cell source, Cell dest) {
        if(isDiagonal(source, dest)) {
            throw new ImposableMoveException("Такой ход невозможен");
        }
        int delta = 0;
        if (source.x != dest.x) {
            delta = source.x - dest.x;
        } else if (source.y != dest.y) {
            delta = source.y - dest.y;
        }
        int deltaY = source.y - dest.y < 0 ? -1 : 1;
        int deltaX = source.x - dest.x > 0 ? -1 : 1;
        int size = Math.abs(delta);
        Cell[] steps = new Cell[size];
        int index = 0;
        for (int i = 0, k = 1; i < size; i++, k++) {
            if (source.x == dest.x) {
                index = 8 * source.x + (source.y - k * deltaY);
            } else if (source.y == dest.y) {
                index = 8 *  (source.x + k * deltaX) + source.y;
            }
            steps[i] = Cell.values()[index];
        }
        return steps;
    }
}

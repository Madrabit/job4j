package ru.job4j.chess.firuges;

/**
 * @author madrabit on 14.08.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("DuplicatedCode")
public abstract class Queen implements Figure {
    private final Cell position;

    public Queen(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        return Math.abs(deltaX) == Math.abs(deltaY);
    }
    @Override
    public Cell[] way(Cell source, Cell dest) {
        int delta = 0;
        if (source.x != dest.x) {
            delta = source.x - dest.x;
        } else if (source.y != dest.y) {
            delta = source.y - dest.y;
        }
        int deltaY = source.y - dest.y < 0 ? -1 : 1;
        int deltaX = source.x - dest.x > 0 ? -1 : 1;
        int kY = source.y - dest.y > 0 ? -1 : 1;
        int size = Math.abs(delta);
        Cell[] steps = new Cell[size];
        int index = 0;
        for (int i = 0, k = 1; i < size; i++, k++) {
            int part = 8 * (source.x + k  * deltaX);
            if (isDiagonal(source, dest)) {
                index = part + (source.y + k * kY);
            } else if (source.x == dest.x) {
                index = 8 * source.x + (source.y - k * deltaY);
            } else if (source.y == dest.y) {
                index = part + source.y;
            }
            steps[i] = Cell.values()[index];
        }
        return steps;
    }
}

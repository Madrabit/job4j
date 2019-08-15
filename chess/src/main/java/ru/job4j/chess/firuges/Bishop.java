package ru.job4j.chess.firuges;

/**
 * @author madrabit on 13.08.2019
 * @version 1$
 * @since 0.1
 */
public abstract class Bishop implements Figure {
    private final Cell position;

    public Bishop(final Cell position) {
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
        if (!isDiagonal(source, dest)) {
            throw new ImposableMoveException("Ход не подиагонали невозможен");
        }
        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        int kX = deltaX > 0 ? -1 : 1;
        int kY = deltaY > 0 ? -1 : 1;
        Cell[] steps = new Cell[Math.abs(dest.x - source.x)];
        for (int i = 0, k = 1; i < steps.length; i++, k++) {
            steps[i] = Cell.values()[8 * (source.x + k  * kX) + (source.y + k * kY)];
        }
        return steps;
    }

}

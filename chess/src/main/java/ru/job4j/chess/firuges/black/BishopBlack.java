package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImposableMoveException;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
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
        if(!isDiagonal(source, dest)) {
            throw new ImposableMoveException("Ход не подиагонали невозможен");
        }
        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        Cell[] steps = new Cell[Math.abs(deltaX)];
//        System.out.println(Cell.valueOf(source.toString()).ordinal());
        for (int i = 0, k = 1; i < steps.length; i++, k++) {
            if (deltaX > 0 && deltaY > 0) {
                steps[i] = (Cell.values()[Math.abs((source.x - k) * 8 + (source.y - k))]) ;
            } else if (deltaX < 0 && deltaY > 0) {
                steps[i] = (Cell.values()[Math.abs((source.x + k) * 8 + (source.y - k))]) ;
            } else if (deltaX > 0 && deltaY < 0) {
                steps[i] = (Cell.values()[Math.abs((source.x - k) * 8 + (source.y + k))]) ;
            } else  if (deltaX < 0 && deltaY < 0) {
                steps[i] = (Cell.values()[Math.abs((source.x + k) * 8 + (source.y + k))]) ;
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

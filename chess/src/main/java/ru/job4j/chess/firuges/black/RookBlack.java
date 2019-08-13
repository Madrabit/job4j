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
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
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


//        int deltaX = source.x - dest.x;
//        int deltaY = source.y - dest.y;
//        int kX = deltaX > 0 ? -1 : 1;
//        int kY = deltaY > 0 ? -1 : 1;
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
        int deltaX = source.x - dest.x < 0 ? -1 : 1;
        int size = Math.abs(delta);
        Cell[] steps = new Cell[size];
        for (int i = 0, k = 1; i < size; i++, k++) {
//            int index = 8 * source.x + (source.y - k * deltaY);
            int shlypa = source.y - (source.x - k * deltaX);
            System.out.println(shlypa);
            int index = 8 * shlypa;
//            int index = 8 * (source.x - k + deltaX);
            System.out.println(index);
            System.out.println(Cell.values()[index]);
            steps[i] = Cell.values()[index];


        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}

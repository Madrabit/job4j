package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImposableMoveException;
import ru.job4j.chess.firuges.Pawn;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack extends Pawn {
    private final Cell position;

    public PawnBlack(final Cell position) {
        super(position);
        this.position = position;
    }

    @Override
    public Pawn copy(Cell dest) {
        return new PawnBlack(dest);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (! (source.y == dest.y + 1 && source.x == dest.x)) {
            throw new ImposableMoveException("Такой ход не возможен");
        }
        return new Cell[] { dest };
    }
}

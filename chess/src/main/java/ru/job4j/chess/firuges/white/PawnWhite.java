package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImposableMoveException;
import ru.job4j.chess.firuges.Pawn;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnWhite extends Pawn {
    private final Cell position;

    public PawnWhite(final Cell position) {
        super(position);
        this.position = position;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (! (source.y == dest.y - 1 && source.x == dest.x)) {
            throw new ImposableMoveException("Такой ход не возможен");
        }
        return new Cell[] { dest };
    }
}

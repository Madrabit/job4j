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
public class KingBlack implements Figure {
    private final Cell position;

    public KingBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (!(
                (source.x == dest.x && source.y == dest.y + 1 )
                || (source.x == dest.x && source.y == dest.y - 1 )
                || (source.x == dest.x + 1 && source.y == dest.y)
                || (source.x == dest.x - 1 && source.y == dest.y)
                || (source.x == dest.x - 1 && source.y == dest.y - 1)
                || (source.x == dest.x + 1 && source.y == dest.y + 1)
                || (source.x == dest.x - 1 && source.y == dest.y + 1)
                || (source.x == dest.x + 1 && source.y == dest.y - 1)
        )) {
            throw new ImposableMoveException("Так фигура ходить не может.");
        }
        return steps = new Cell[] { dest };
    }
    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}

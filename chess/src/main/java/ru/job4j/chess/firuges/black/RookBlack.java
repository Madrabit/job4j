package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImposableMoveException;
import ru.job4j.chess.firuges.Rook;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookBlack extends Rook {
    private final Cell position;

    public RookBlack(final Cell position) {
        super(position);
        this.position = position;
    }

    @Override
    public Rook copy(Cell dest) {
        return new RookBlack(dest);
    }
}

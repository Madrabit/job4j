package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.King;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KingWhite extends King {
    private final Cell position;

    public KingWhite(final Cell position) {
        super(position);
        this.position = position;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}

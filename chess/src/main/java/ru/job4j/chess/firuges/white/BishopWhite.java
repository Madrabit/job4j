package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Bishop;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite extends Bishop {
    private final Cell position;

    public BishopWhite(final Cell position) {
        super(position);
        this.position = position;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}

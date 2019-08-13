package ru.job4j.chess.firuges;

import ru.job4j.chess.firuges.black.PawnBlack;

/**
 * @author madrabit on 13.08.2019
 * @version 1$
 * @since 0.1
 */
public abstract class Pawn implements Figure {

        private final Cell position;

        public Pawn(final Cell position) {
            this.position = position;
        }

        public Cell position() {
            return this.position;
        }

        public Cell[] way(Cell source, Cell dest) {
            Cell[] steps = new Cell[0];
            if (! (source.x == dest.x)) {
                throw new ImposableMoveException("Такой ход не возможен");
            }
            return new Cell[] { dest };
        }
}

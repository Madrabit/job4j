package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * @author madrabit on 15.08.2019
 * @version 1$
 * @since 0.1
 */
public class LogicTest {
    @Test
    public void whenBishopInDiagonalWayThenTrue() {
        BishopWhite bishopWhite = new BishopWhite(Cell.C1);
       Cell[] result = bishopWhite.way(Cell.C1,Cell.D2);
        assertThat(result, is(new Cell[]{Cell.D2}));
    }

    @Test
    public void bishopUpRight() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Cell[] actual = bishop.way(bishop.position(), Cell.H8);
        Cell[] expected = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        assertThat(actual, is(expected));
    }

    @Test
    public void bishopUpLeft() {
        BishopBlack bishop = new BishopBlack(Cell.H1);
        Cell[] actual = bishop.way(bishop.position(), Cell.A8);
        Cell[] expected = {Cell.G2, Cell.F3, Cell.E4, Cell.D5, Cell.C6, Cell.B7, Cell.A8};
        assertThat(actual, is(expected));
    }

    @Test
    public void bishopDownRight() {
        BishopBlack bishop = new BishopBlack(Cell.A8);
        Cell[] actual = bishop.way(bishop.position(), Cell.H1);
        Cell[] expected = {Cell.B7, Cell.C6, Cell.D5, Cell.E4, Cell.F3, Cell.G2, Cell.H1};
        assertThat(actual, is(expected));
    }

    @Test
    public void bishopDownLeft() {
        BishopBlack bishop = new BishopBlack(Cell.H8);
        Cell[] actual = bishop.way(bishop.position(), Cell.A1);
        Cell[] expected = {Cell.G7, Cell.F6, Cell.E5, Cell.D4, Cell.C3, Cell.B2, Cell.A1};
        assertThat(actual, is(expected));
    }

    @Test
    public void whenRookInLineThenTrue() {
       RookWhite rookWhite = new RookWhite(Cell.A1);
       Cell[] result = rookWhite.way(Cell.A1,Cell.A4);
       assertThat(result, is(new Cell[]{Cell.A2, Cell.A3, Cell.A4}));
    }

    @Test
    public void whenPawnInOneVerticalStepThenTrue() {
        PawnWhite pawnWhite = new PawnWhite(Cell.B2);
        Cell[] result = pawnWhite.way(Cell.B2,Cell.B3);
        assertThat(result, is(new Cell[]{Cell.B3}));
    }

    @Test
    public void whenQueenInDiagonalOrStraightWayThenTrue() {
        QueenWhite queenWhite = new QueenWhite(Cell.B2);
        Cell[] result = queenWhite.way(Cell.B2,Cell.B5);
        assertThat(result, is(new Cell[]{Cell.B3, Cell.B4, Cell.B5}));
    }

    @Test
    public void whenKingInOneStepThenTrue() {
        KingWhite kingWhite = new KingWhite(Cell.E1);
        Cell[] result = kingWhite.way(Cell.E1,Cell.E2);
        assertThat(result, is(new Cell[]{Cell.E2}));
    }

    @Test
    public void whenKnightInKnigthWayThenTrue() {
        KnightWhite knightWhite = new KnightWhite(Cell.B1);
        Cell[] result = knightWhite.way(Cell.B1,Cell.D2);
        assertThat(result, is(new Cell[]{Cell.D2}));
    }

}

package ru.job4j.design.tablegame;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit
 */
public class GameTest {
    Board board = new SimpleBoard();

    @Test
    public void whenPlayerDrawThenFigureChangePosition() {
        Figure figure = new SimpleFigure("car", "black");
        Player player = new Player(figure, "player1");
        board.add(player);

        int startPosition = player.getFigure().getPosition();

        board.distribute(player);

        int finalPosition = player.getFigure().getPosition();
        assertNotEquals(finalPosition, startPosition);
    }

    @Test
    public void whenFigureOnBackwardPointThenMovesBack() {
        Point blackPoint = new BackwardPoint();
        int position = 5;
        blackPoint.setPosition(position);

        Player player = null;
        int start = player.getFigure().getPosition();
        player.getFigure().setPosition(position);


        boolean result = player.getFigure().getPosition() < position;
        assertThat(result, is(true));
    }
}

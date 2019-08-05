package ru.job4j.oop;

/**
 * @author madrabit on 05.08.2019
 * @version 1$
 * @since 0.1
 */
public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        hare.tryEat(ball);
        ball.run();
        wolf.tryEat(ball);
        ball.run();
        fox.tryEat(ball);
    }
}

package ru.job4j.design.tablegame;

/**
 * @author madrabit
 * Точка, которая сдвигает Игрока НАЗАД при попадании на неё.
 */
public class BackwardPoint implements Point {

    @Override
    public void setPosition(int position) {

    }

    @Override
    public boolean check(Player player) {
        return false;
    }
}

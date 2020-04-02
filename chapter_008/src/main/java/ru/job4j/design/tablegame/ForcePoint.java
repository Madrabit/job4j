package ru.job4j.design.tablegame;

/**
 * @author madrabit
 * Точка, которая сдвигает Игрока ВПЕРЕД при попадании на неё.
 */
public class ForcePoint implements Point {
    @Override
    public void setPosition(int position) {

    }

    @Override
    public boolean check(Player player) {
        return false;
    }
}

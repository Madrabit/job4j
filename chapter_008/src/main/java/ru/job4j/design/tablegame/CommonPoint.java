package ru.job4j.design.tablegame;

/**
 * @author madrabit
 * Обычная точка, которая не сдвигает Игрока
 */
public class CommonPoint implements Point {

    @Override
    public void setPosition(int position) {

    }

    @Override
    public boolean check(Player player) {
        return false;
    }

}

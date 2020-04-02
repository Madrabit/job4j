package ru.job4j.design.tablegame;


/**
 * Интерфейс точки на игровой доске.
 */
public interface Point {
    void setPosition(int position);

    boolean check(Player player);
}

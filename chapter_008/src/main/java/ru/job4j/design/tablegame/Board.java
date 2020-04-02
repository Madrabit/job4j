package ru.job4j.design.tablegame;


/**
 * Интерфейс доски
 */
public interface Board {

    void add(Player player);

    void distribute(Player player);

}

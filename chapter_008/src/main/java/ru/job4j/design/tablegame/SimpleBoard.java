package ru.job4j.design.tablegame;

import java.util.HashMap;
import java.util.List;

/**
 * @author madrabit
 * Игровая доска.
 */
public class SimpleBoard implements Board {
    int size;
    List<Player> playerList;

    HashMap<Point, List<Player>> field;

    List<Point> points;


    /**
     * Добавление игроков на доску.
     * @param player
     */
    @Override
    public void add(Player player) {

    }

    /**
     * 1) Игрок кидает кубик draw - обновляется значение позиции.
     * 2) Игрок проверяется по пойнтам и смещается в зависимости от точки на какую попал.
     * 3) Смещает игрока на новую позицию
     */
    public void distribute(Player player) {
        player.draw();
        for (Point point : points) {
            if (point.check(player)) {
                move(player);
            }
        }
    }

    /**
     * Находит игрока на доске, забирает его с позиции и станвит на новую.
     */
    private void move(Player player) {

    }




}

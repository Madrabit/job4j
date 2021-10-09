package ru.job4j.design.tablegame;

/**
 * @author madrabit
 * Реализация фигры.
 */
public class SimpleFigure implements Figure {
    /**
     * Как она выглядит.
     */
    String look;
    /**
     * Цвет фигуры.
     */
    String color;

    int position = 0;

    public SimpleFigure(String look, String color) {
        this.look = look;
        this.color = color;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

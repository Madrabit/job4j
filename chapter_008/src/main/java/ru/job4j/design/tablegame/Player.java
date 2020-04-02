package ru.job4j.design.tablegame;

public class Player {
    Figure figure = null;
    String name;


    /**
     * Возвращаю радомное число на "кубике".
     * Берет позицию фигуры, прибавляет к ней это число.
     * Получаем реальную позицию на доске, которую потом сверим с Точкой на доске.
     * Берем координату доски и проверяем её Точку (Двигает назад, вперед или на месте стоит)
     * @return
     */
    public int draw() {
        return 0;
    };


    public Player(Figure figure, String name) {
        this.figure = figure;
        this.name = name;
    }


    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }
}

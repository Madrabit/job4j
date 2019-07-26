package ru.job4j.condition;

/**
 * Класс вычисления расстояния между точками в системе координат.
 */
@SuppressWarnings("CanBeFinal")
public class Point {
    /**
     * X - точки
     */
    private int x;
    /**
     * Y - точки
     */
    private int y;
    /**
     * Z - точка
     */
    private int z;
    /**
     * Конструтор, который принимает начальное состояние объекта "точка"
     * @param x координата x
     * @param y координата y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Конструтор, который принимает начальное состояние объекта "точка"
     * @param x координата x
     * @param y координата y
     * @param z координата z
     */
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * метод вычисления расстояния между точками.
     * @param that точка.
     * @return расстояние
     */
    public double distance(Point that) {
        return Math.sqrt(Math.pow((this.x - that.x), 2) + Math.pow((this.y - that.y), 2));
    }

    /**
     * Метод вычисления расстояния между точками в трехмерном пространстве.
     * @param that Точка
     * @return расстояние
     */
    public double distance3D(Point that) {
        return Math.sqrt(Math.pow((this.x - that.x), 2) + Math.pow((this.y - that.y), 2)
                + Math.pow((this.z - that.z), 2));
    }

    /**
     * Вывод координат точки
     */
    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
}

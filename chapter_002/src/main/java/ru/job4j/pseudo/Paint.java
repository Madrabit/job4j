package ru.job4j.pseudo;

/**
 * @author madrabit on 30.07.2019
 * @version 1$
 * @since 0.1
 */
public class Paint {
    /**
     * Печатает псевдокартинку.
     * @param shape Объект, который будет отрисован.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint square = new Paint();
        Paint triangle = new Paint();
        square.draw(new Square());
        triangle.draw(new Triangle());
    }
}

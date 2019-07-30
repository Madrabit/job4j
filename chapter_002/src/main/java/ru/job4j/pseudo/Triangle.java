package ru.job4j.pseudo;

/**
 * Класс Трегугольника.
 * @author madrabit on 30.07.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("StringBufferReplaceableByString")
public class Triangle implements Shape {
    /**
     * Отрисовывает треугольник.
     * @return Возвращает треугольник ввиде строки.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("--+--");
        pic.append(System.getProperty("line.separator"));
        pic.append("-+-+-");
        pic.append(System.getProperty("line.separator"));
        pic.append("+---+");
        return pic.toString();
    }
}

package ru.job4j.pseudo;

/**
 * @author madrabit on 30.07.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("StringBufferReplaceableByString")
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append(System.getProperty("line.separator"));
        pic.append("+  +");
        pic.append(System.getProperty("line.separator"));
        pic.append("+  +");
        pic.append(System.getProperty("line.separator"));
        pic.append("++++");
        return pic.toString();
    }
}

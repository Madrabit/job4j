package ru.job4j.inheritance;

/**
 * @author madrabit on 26.07.2019
 * @version 1$
 * @since 0.1
 */
public class Engineer extends Profession {
    private int ingenuity;

    public int getIngenuity() {
        return ingenuity;
    }

    public Evaluation check(Architecture architecture) {
        return new Evaluation();
    }

    public Engineer(String name) {
        super(name);
    }
}

package ru.job4j.inheritance;

/**
 * @author madrabit on 26.07.2019
 * @version 1$
 * @since 0.1
 */
public class Builder extends Engineer {
    private int bricks;

    public int getBricks() {
        return bricks;
    }

    public Builder(String name) {
        super(name);
    }
}

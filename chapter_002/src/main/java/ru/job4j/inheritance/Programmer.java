package ru.job4j.inheritance;

/**
 * @author madrabit on 26.07.2019
 * @version 1$
 * @since 0.1
 */
public class Programmer extends Engineer {
    boolean godlike;

    public boolean isGodlike() {
        return godlike;
    }

    public Programmer(String name) {
        super(name);
    }

    public Program code(Architecture architecture) {
        return new Program();
    }
}

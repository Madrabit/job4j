package ru.job4j.inheritance;

/**
 * @author madrabit on 26.07.2019
 * @version 1$
 * @since 0.1
 */
public class Surgeon extends  Doctor {
    private int scalpel;

    public int getScalpel() {
        return scalpel;
    }

    public Surgeon(String name) {
        super(name);
    }

    public Viscera cut(Patient patient) {
        return new Viscera();
    }
}

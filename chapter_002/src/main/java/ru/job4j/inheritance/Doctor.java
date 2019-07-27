package ru.job4j.inheritance;

/**
 * @author madrabit on 26.07.2019
 * @version 1$
 * @since 0.1
 */
public class Doctor extends Profession {
    private int painLevel;

    public int getPainLevel() {
        return painLevel;
    }

    public Diagnose heal(Patient patient) {
        return new Diagnose();
    }

    public Doctor(String name) {
        super(name);
    }
}

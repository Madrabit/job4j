package ru.job4j.inheritance;

/**
 * @author madrabit on 26.07.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("SameReturnValue")
public class Dentist extends Doctor {
    private int teeth;
    private boolean satisfaction;

    public boolean isSatisfaction() {
        return satisfaction;
    }

    public int getTeeth() {
        return teeth;
    }

    public Dentist(String name) {
        super(name);
    }

    public boolean showCruelty(Pain pain) {
        return false;
    }

}

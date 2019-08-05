package ru.job4j.oop;

/**
 * @author madrabit on 05.08.2019
 * @version 1$
 * @since 0.1
 */
public class Battery {
    private int load;
    public void exchange(Battery another) {
        this.load = this.load + another.load;
        another.load = 0;
    }
}

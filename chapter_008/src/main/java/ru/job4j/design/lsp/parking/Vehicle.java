package ru.job4j.design.lsp.parking;

/**
 * @author madrabit
 */
public abstract class Vehicle {
    private int size;
    private int number;

    public Vehicle(int size, int number) {
        this.size = size;
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

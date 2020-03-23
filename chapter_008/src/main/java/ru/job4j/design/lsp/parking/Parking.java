package ru.job4j.design.lsp.parking;

/**
 * @author madrabit
 */
public interface Parking {
    boolean checkVehicle(Vehicle vehicle);

    void add(Vehicle vehicle);
}

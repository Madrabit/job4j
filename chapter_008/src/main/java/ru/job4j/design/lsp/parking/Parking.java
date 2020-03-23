package ru.job4j.design.lsp.parking;

import java.util.List;

/**
 * @author madrabit
 */
public interface Parking {


    boolean checkVehicle(Vehicle vehicle);

    void add(Vehicle vehicle);

    List<Vehicle> getVehicleList();
}

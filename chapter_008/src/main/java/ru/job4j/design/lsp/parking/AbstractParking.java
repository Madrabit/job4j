package ru.job4j.design.lsp.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author madrabit
 */
public abstract class AbstractParking implements Parking {
    private final List<Vehicle> vehicleList;

    final int size;

    public AbstractParking(int size) {
        this.vehicleList = new ArrayList<>(size);
        this.size = size;
    }

    @Override
    public void add(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }
}

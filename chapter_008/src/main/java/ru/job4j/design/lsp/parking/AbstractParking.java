package ru.job4j.design.lsp.parking;

import com.sun.javafx.scene.control.SizeLimitedList;

/**
 * @author madrabit
 */
public abstract class AbstractParking implements Parking {
    SizeLimitedList<Vehicle> vehicleList;

    int size;

    public AbstractParking(int size) {
        this.vehicleList = new SizeLimitedList<>(size);
    }

    @Override
    public void add(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }


}

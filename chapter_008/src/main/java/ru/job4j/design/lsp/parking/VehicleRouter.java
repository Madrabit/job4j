package ru.job4j.design.lsp.parking;

import java.util.List;

/**
 * @author madrabit
 */
public class VehicleRouter {
    List<Parking> parkings;

    public VehicleRouter(List<Parking> parkings) {
        this.parkings = parkings;
    }

    public void route(Vehicle vehicle) {
        for (Parking parking : parkings) {
            if (parking.checkVehicle(vehicle)) {
                parking.add(vehicle);
            }
        }
    }
}

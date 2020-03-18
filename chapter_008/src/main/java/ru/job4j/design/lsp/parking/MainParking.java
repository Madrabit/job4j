package ru.job4j.design.lsp.parking;

import java.util.List;

/**
 * @author madrabit
 */
public class MainParking implements IMainParking {
    private int passengerPlaces;
    private int truckPlaces;

    public MainParking(int passengerPlaces, int truckPlaces) {
        this.passengerPlaces = passengerPlaces;
        this.truckPlaces = truckPlaces;
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        return false;
    }

    public int getPassengerPlaces() {
        return passengerPlaces;
    }

    public void setPassengerPlaces(int passengerPlaces) {
        this.passengerPlaces = passengerPlaces;
    }

    public int getTruckPlaces() {
        return truckPlaces;
    }

    public void setTruckPlaces(int truckPlaces) {
        this.truckPlaces = truckPlaces;
    }
}

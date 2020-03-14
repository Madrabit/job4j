package ru.job4j.design.lsp.parking;

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
}

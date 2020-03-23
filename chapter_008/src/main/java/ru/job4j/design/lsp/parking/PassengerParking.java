package ru.job4j.design.lsp.parking;

/**
 * @author madrabit
 */
public class PassengerParking extends AbstractParking {
    int modsize;

    public PassengerParking(int size) {
        super(size);
    }

    public boolean checkVehicle(Vehicle vehicle) {
        boolean result = false;
        if (modsize < size) {
            modsize++;
            result = true;
        }
        return result;
    }
}

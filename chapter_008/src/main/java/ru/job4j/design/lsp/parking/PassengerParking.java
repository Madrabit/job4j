package ru.job4j.design.lsp.parking;

/**
 * @author madrabit
 */
public class PassengerParking extends AbstractParking{
    public PassengerParking(int size) {
        super(size);
    }

    public boolean checkVehicle(Vehicle vehicle) {
        boolean result = false;
        if (size > 0) {
            size++;
            result = true;
        }
        return result;
    }
}

package ru.job4j.design.lsp.parking;

/**
 * @author madrabit
 */
public class TruckParking extends AbstractParking {
    int modsize;

    public TruckParking(int size) {
        super(size);
    }

    public boolean checkVehicle(Vehicle vehicle) {
        boolean result = false;
        if (modsize < size && vehicle.getSize() == 2) {
            modsize += 2;
            result = true;
        }
        return result;
    }
}

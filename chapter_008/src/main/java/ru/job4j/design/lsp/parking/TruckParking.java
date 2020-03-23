package ru.job4j.design.lsp.parking;

import com.sun.javafx.scene.control.SizeLimitedList;

import java.util.List;

/**
 * @author madrabit
 */
public class TruckParking extends AbstractParking{
    public TruckParking(int size) {
        super(size);
    }

    public boolean checkVehicle(Vehicle vehicle) {
        boolean result = false;
        if (size > 1) {
            result = true;
        } else {

        }
        return result;
    }
}

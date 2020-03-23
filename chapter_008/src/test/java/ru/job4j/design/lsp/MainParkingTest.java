package ru.job4j.design.lsp;

import org.junit.Test;
import ru.job4j.design.lsp.parking.MainParking;
import ru.job4j.design.lsp.parking.PassengerCar;
import ru.job4j.design.lsp.parking.Truck;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit
 */
public class MainParkingTest {
    @Test
    public void whenAdd3carsThenReturn3OnTheParking() {
        MainParking parking = new MainParking(5, 5);
        for (int i = 0; i < 3; i++) {
            parking.addVehicle(new PassengerCar(1, i));
        }

        assertThat(3, is(parking.getPassengerPlaces()));

    }

    @Test
    public void whenAdd3trucksThenReturnParkingField2() {
        MainParking parking = new MainParking(2, 1);
        for (int i = 0; i < 3; i++) {
            parking.addVehicle(new Truck(2, i));
        }

        int ammount = parking.getPassengerPlaces() + parking.getTruckPlaces();

        assertThat(2, is(ammount));

    }
}

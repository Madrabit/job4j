package ru.job4j.design.lsp;

import org.junit.Test;
import ru.job4j.design.lsp.parking.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit
 */
public class MainParkingTest {
    @Test
    public void whenAdd3carsThenReturn3OnTheParking() {
        List<Parking> parkingList = new ArrayList<>(Collections.singletonList(new PassengerParking(3)));
        VehicleRouter router = new VehicleRouter(parkingList);
        for (int i = 0; i < 3; i++) {
            router.route(new PassengerCar(1, i));
        }
        assertThat(3, is(parkingList.get(0).getVehicleList().size()));

    }

    @Test
    public void whenAdd3trucksThenReturnParkingField2() {
        List<Parking> parkingList = new ArrayList<>(Arrays.asList(
                new TruckParking(1), new PassengerParking(2)));
        VehicleRouter router = new VehicleRouter(parkingList);
        for (int i = 0; i < 10; i++) {
            router.route(new Truck(2, i));
        }

        int amount = parkingList.get(0).getVehicleList().size()
                + parkingList.get(1).getVehicleList().size();

        assertThat(3, is(amount));

    }
}

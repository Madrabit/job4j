package ru.job4j.design.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit
 */
public class ControlQualityTest {
    @Test
    public void someTest() {
        Storage shop = new Shop(new ArrayList<>());
        Storage warehouse = new Warehouse(new ArrayList<>());
        Storage trash = new Trash(new ArrayList<>());


        Food oldFish = new Fish("Cod",
                LocalDate.of(2020, 3, 1),
                LocalDate.of(2020, 3, 14),
                200,
                10
        );
        ControlQuality controlQuality = new ControlQuality(shop, warehouse, trash);
        controlQuality.distribute(oldFish);
        assertThat(180, is(shop.getStorage().get(0).getPrice()));
    }
}

package ru.job4j.design.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        List<Storage> storage = new ArrayList<>(List.of(shop, warehouse, trash));
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.distribute(oldFish);
        assertThat(180, is(storage.get(0).getStorage().get(0).getPrice()));
    }
}

package ru.job4j.addresses;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author madrabit on 16.09.2019
 * @version 1$
 * @since 0.1
 */
public class MainTest {
    @Test
    public void whenCollectThenReturnAddresses() {
        Profile profile1 = new Profile(new Address("Spb", "Nevskiy", 5, 2));
        Profile profile2 = new Profile(new Address("Moscow", "Nevskiy", 5, 2));
        List<Profile> list = new ArrayList<>();
        list.add(profile1);
        list.add(profile2);
        Main main =  new Main();
        List<Address> addresses = main.collect(list);
        assertThat(addresses.toString(),
                is("[Address{city='Spb', street='Nevskiy', home=5, apartment=2}, " +
                        "Address{city='Moscow', street='Nevskiy', home=5, apartment=2}]"));
    }
    @Test
    public void whenCollectThenReturnSortedUniqueAddresses() {
        Profile profile1 = new Profile(new Address("Ural", "Lubyanka", 3, 33));
        Profile profile2 = new Profile(new Address("Spb", "Nevskiy", 5, 2));
        Profile profile3 = new Profile(new Address("Spb", "Nevskiy", 5, 2));
        Profile profile4 = new Profile(new Address("Moscow", "Nevskiy", 5, 2));
        List<Profile> list = new ArrayList<>();
        list.add(profile1);
        list.add(profile2);
        list.add(profile3);
        list.add(profile4);
        Main main =  new Main();
        List<Address> addresses = main.collectUnique(list);
        assertThat(addresses.toString(),
                is("[" + "Address{city='Moscow', street='Nevskiy', home=5, apartment=2}, "
                        + "Address{city='Spb', street='Nevskiy', home=5, apartment=2}, "
                        + "Address{city='Ural', street='Lubyanka', home=3, apartment=33}]"));
    }
}

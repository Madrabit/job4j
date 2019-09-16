package ru.job4j.addresses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        Profile profile1 = new Profile(new Address("Moscow", "Lubyanka", 3, 33));
        Profile profile2 = new Profile(new Address("Spb", "Nevskiy", 5, 2));
        List<Profile> list = new ArrayList<>();
        list.add(profile1);
        list.add(profile2);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Lubyanka", 3, 33));
        expected.add(new Address("Spb", "Nevskiy", 5, 2));
        Main main =  new Main();
        List<Address> addresses = main.collect(list);
        assertEquals(expected, addresses);
    }
}

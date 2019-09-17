package ru.job4j.addresses;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Main method
 * @author madrabit on 16.09.2019
 * @version 1$
 * @since 0.1
 */
public class Main {
    /**
     * Method returns addresses from all profiles.
     * @param profiles List of profiles.
     * @return List of addresses.
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }
}

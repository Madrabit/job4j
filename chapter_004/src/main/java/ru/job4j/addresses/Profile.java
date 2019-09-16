package ru.job4j.addresses;

/**
 * Tourist profile
 * @author madrabit on 16.09.2019
 * @version 1$
 * @since 0.1
 */
public class Profile {
    /**
     * Tourist address
     */
    private final Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}

package ru.job4j.addresses;

import java.util.Objects;

/**
 * Tourist's place of residence
 * @author madrabit on 16.09.2019
 * @version 1$
 * @since 0.1
 */
public class Address {
    /**
     * City
     */
    private final String city;
    /**
     * Street
     */
    private final String street;
    /**
     * Home
     */
    private final int home;
    /**
     * Apartment
     */
    private final int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{"
                + "city='" + city + '\''
                + ", street='" + street + '\''
                + ", home=" + home
                + ", apartment=" + apartment
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}

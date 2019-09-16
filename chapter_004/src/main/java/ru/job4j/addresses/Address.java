package ru.job4j.addresses;

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

    @Override
    public String toString() {
        return "Address{"
                + "city='" + city + '\''
                + ", street='" + street + '\''
                + ", home=" + home
                + ", apartment=" + apartment
                + '}';
    }
}

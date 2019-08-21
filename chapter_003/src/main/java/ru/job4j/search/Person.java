package ru.job4j.search;

/**
 * Человек занесенный заносимый в справочник
 * @author madrabit on 21.08.2019
 * @version 1$
 * @since 0.1
 */
public class Person {
    private final String name;
    private final String surname;
    private final String phone;
    private final String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}

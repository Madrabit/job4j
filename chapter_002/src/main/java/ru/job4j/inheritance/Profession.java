package ru.job4j.inheritance;

/**
 * @author madrabit on 26.07.2019
 * @version 1$
 * @since 0.1
 */
public class Profession {
    private final String name;
    private String surname;
    private String education;
    private String birthday;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }

    public Profession(String name) {
        this.name = name;
    }
}

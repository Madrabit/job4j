package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Телефонный справочник
 * @author madrabit on 21.08.2019
 * @version 1$
 * @since 0.1
 */
public class PhoneDictionary {
    private final List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (var person : persons) {
                if (person.getName().contains(key)
                        || person.getSurname().contains(key)
                        || person.getAddress().contains(key)
                        || person.getPhone().contains(key)
                ) {
                    result.add(person);
                }
        }
        return result;
    }
}

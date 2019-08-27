package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс отсортированных пользователй по возрасту.
 * @author madrabit on 27.08.2019
 * @version 1$
 * @since 0.1
 */
public class SortUser {
    /**
     * Класс польхователя.
     */
    @SuppressWarnings("FieldCanBeLocal")
    static class User implements Comparable<User> {

        /**
         * Возраст пользователя.
         */
        private final int age;
        /**
         * Имя пользователя.
         */
        private final String name;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(User user) {
            return this.age > user.age ? 1  : -1;
        }
    }

    /**
     * Метод возвращает TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
     * @param list Список пользователей.
     * @return Отсортрированный список по возврасту.
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }
}

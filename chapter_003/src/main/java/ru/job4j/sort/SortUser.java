package ru.job4j.sort;

import java.util.Comparator;
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
    @SuppressWarnings({"FieldCanBeLocal", "RedundantSuppression"})
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

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(User user) {
            return Integer.compare(this.age, user.age);
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

    @SuppressWarnings("Convert2Lambda")
    public List<User> sortNameLength(List<User> list) {
        list.sort(
                new Comparator<>() {
                    @Override
                    public int compare(User user, User t1) {
                        return Integer.compare(user.name.length(), t1.name.length());
                    }
                }
        );
        return list;
    }

    @SuppressWarnings("Convert2Lambda")
    public List<User> sortByAllFields(List<User> list) {
        list.sort(
                new Comparator<>() {
                    @Override
                    public int compare(User user, User t1) {
                        int lexCompare = t1.name.compareTo(user.name);
                        if (lexCompare != 0) {
                            return lexCompare;
                        }
                        return Integer.compare(user.age, t1.age);
                    }
                }
        );
        return list;
    }
}

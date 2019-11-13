package ru.job4j.analyzer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Check difference between to List.
 *
 * @author madrabit on 12.11.2019
 * @version 1$
 * @since 0.1
 */
public class Analyzer {


    /**
     * Check Added items.
     *
     * @param previous First List.
     * @param current  Second List.
     * @return The Number of added items.
     */
    private int addCheck(List<User> previous, List<User> current) {
        List<User> list = new ArrayList<>(current);
        list.removeAll(previous);
        return list.size();
    }

    /**
     * Check Deleted items.
     *
     * @param previous First List.
     * @param current  Second List.
     * @return The Number of deleted items.
     */
    private int delCheck(List<User> previous, List<User> current) {
        List<User> list = new ArrayList<>(previous);
        list.retainAll(current);
        return previous.size() - list.size();
    }

    /**
     * Check Changed items.
     *
     * @param previous First List.
     * @param current  Second List.
     * @return The Number of changed items.
     */
    private int changeCheck(List<User> previous, List<User> current) {
        Map<Integer, String> prevMap = previous.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        Map<Integer, String> curMap = current.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        int dif = 0;
        for (Map.Entry<Integer, String> entry : curMap.entrySet()) {
            if (prevMap.containsKey(entry.getKey()) &&
                    !prevMap.get(entry.getKey()).equals(entry.getValue())) {
                dif++;
            }
        }
        return dif;
    }

    /**
     * Check difference between to List.
     *
     * @param previous First List.
     * @param current  Second List.
     * @return Return object contains with add, delete and changes statistic.
     */
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        info.added = addCheck(previous, current);
        info.deleted = delCheck(previous, current);
        info.changed = changeCheck(previous, current);
        return info;
    }

    public static class User {
        final int id;
        final String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {

        int added;
        int changed;
        int deleted;

        public int getAdded() {
            return added;
        }

        public int getDeleted() {
            return deleted;
        }

        public int getChanged() {
            return changed;
        }
    }
}

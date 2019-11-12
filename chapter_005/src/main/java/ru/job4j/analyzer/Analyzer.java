package ru.job4j.analyzer;

import java.util.List;
import java.util.Objects;

/**
 * Check difference between to List.
 * @author madrabit on 12.11.2019
 * @version 1$
 * @since 0.1
 */
public class Analyzer {

    /**
     * Check difference between to List.
     * @param previous First List.
     * @param current Second List.
     * @return Return object contains with add, delete and changes statistic.
     */
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        int prevSize = previous.size();
        int currentSize = current.size();
        if (prevSize < currentSize) {
            info.added = currentSize - prevSize;
        } else if (prevSize > currentSize) {
            info.deleted = prevSize - currentSize;
        } else {
            int equal = 0;
            for (int i = 0; i < prevSize; i++) {
                if (previous.get(i).equals(current.get(i))) {
                    equal++;
                }
            }
            info.changed = prevSize - equal;
        }
        return info;
    }

    public static class User {
        final int id;
        final String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id &&
                    Objects.equals(name, user.name);
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

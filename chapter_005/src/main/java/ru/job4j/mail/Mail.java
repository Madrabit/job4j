package ru.job4j.mail;

import java.util.*;

/**
 * @author madrabit on 20.11.2019
 * @version 1$
 * @since 0.1
 */
public class Mail {
    public static List<User> join(List<User> users) {
        Map<String, User> map = new HashMap<>();
        Set<User> userSet = new LinkedHashSet<>();
        for (User user : users) {
            for (String mail : user.getMails()) {
                if (map.containsKey(mail)) {
                    user.getMails().removeAll(map.get(mail).getMails());
                    map.get(mail).addMail(user.getMails());
                } else {
                    map.put(mail, user);
                    userSet.add(user);
                }
            }
        }
        return new ArrayList<>(userSet);
    }
}

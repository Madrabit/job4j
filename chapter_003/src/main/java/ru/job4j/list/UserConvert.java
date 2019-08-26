package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * Программу преобразования List в Map.
 * @author madrabit on 26.08.2019
 * @version 1$
 * @since 0.1
 */
public class UserConvert {
    /**
     * принимает в себя список пользователей и конвертирует его в Map с ключом Integer id и соответствующим ему User
     * @param list Входной список юзеров.
     * @return Выходной список юзеров ввиде структуры Map.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : list) {
            map.put(user.id, user);
        }
        return map;
    }
}

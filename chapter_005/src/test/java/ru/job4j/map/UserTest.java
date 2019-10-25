package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author madrabit on 21.10.2019
 * @version 1$
 * @since 0.1
 */
public class UserTest {
    @Test
    public void whenEqualsAndHashcodeNotOverriddenShouldBeDifferentObj() {
        User first = new User("Bob", 1,
                new GregorianCalendar(2019, Calendar.NOVEMBER, 21, 14, 48, 0));
        User second = new User("Bob", 1,
                new GregorianCalendar(2019, Calendar.NOVEMBER, 21, 14, 48, 0));
        Map<User, String> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
    }
}

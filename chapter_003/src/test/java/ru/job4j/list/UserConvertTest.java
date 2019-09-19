package ru.job4j.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;

/**
 * @author madrabit on 26.08.2019
 * @version 1$
 * @since 0.1
 */
public class UserConvertTest {
    @Test
    public void whenUserListThenHashMap() {
        List<User> list = new ArrayList<>(List.of(
                new User(1, "Вася", "Урюпинск"),
                new User(2, "Коля", "Питер")
        ));
        UserConvert userConvert = new UserConvert();
        HashMap map =  userConvert.process(list);
        User item = (User) map.get(1);
        String result = item.name;
        Assert.assertThat(result, is("Вася"));
    }
}

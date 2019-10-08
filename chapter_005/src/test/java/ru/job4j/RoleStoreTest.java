package ru.job4j;

import org.junit.Test;
import ru.job4j.generic.Role;
import ru.job4j.generic.RoleStore;
import ru.job4j.generic.SimpleArray;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author madrabit on 08.10.2019
 * @version 1$
 * @since 0.1
 */
public class RoleStoreTest {
    @Test
    public void whenRoleAddThenFindByIdSameRole() {
        RoleStore<Role> roleStore = new RoleStore<>(new SimpleArray(Role.class, 3));
        Role role = new Role("aaa");
        roleStore.add(role);
        assertThat(roleStore.findById("aaa"), is(role));
    }

    @Test
    public void whenRoleDeleteThenTrue() {
        RoleStore<Role> roleStore = new RoleStore<>(new SimpleArray(Role.class, 3));
        Role role = new Role("aaa");
        Role role2 = new Role("bbb");
        roleStore.add(role);
        roleStore.add(role2);
        boolean result = roleStore.delete("bbb");
        assertThat(result, is(true));
    }
}

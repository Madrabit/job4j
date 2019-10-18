package ru.job4j.generic;

import org.junit.Test;
import ru.job4j.generic.Role;
import ru.job4j.generic.RoleStore;

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
        RoleStore<Role> roleStore = new RoleStore<>(3);
        Role role = new Role("aaa");
        Role role2 = new Role("bbb");
        Role role3 = new Role("ссс");
        roleStore.add(role);
        roleStore.add(role2);
        roleStore.add(role3);
        assertThat(roleStore.findById("ссс"), is(role3));
    }

    @Test
    public void whenRoleDeleteThenTrue() {
        RoleStore<Role> roleStore = new RoleStore<>(3);
        Role role = new Role("aaa");
        Role role2 = new Role("bbb");
        Role role3 = new Role("ссс");
        roleStore.add(role);
        roleStore.add(role2);
        roleStore.add(role3);
        boolean result = roleStore.delete("bbb");
        assertThat(result, is(true));
    }
}

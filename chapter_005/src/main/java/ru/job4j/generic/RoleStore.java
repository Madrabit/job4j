package ru.job4j.generic;

/**
 * @author madrabit on 07.10.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("EmptyMethod")
public class RoleStore<Role> extends AbstractStore {

    final SimpleArray<Role> store;

    public RoleStore(SimpleArray store) {
        super(store);
        this.store = store;
    }
}

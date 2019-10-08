package ru.job4j.generic;

/**
 * @author madrabit on 07.10.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("EmptyMethod")
public class RoleStore<Role> extends AbstractStore {

    final SimpleArray<Role> store;

    public RoleStore(SimpleArray<Role> store) {
        super(store);
        this.store = store;
    }

    @Override
    public void add(Base model) {

    }

    @Override
    public boolean replace(String id, Base model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Base findById(String id) {
        return null;
    }
}

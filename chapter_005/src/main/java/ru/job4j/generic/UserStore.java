package ru.job4j.generic;

/**
 * @author madrabit on 07.10.2019
 * @version 1$
 * @since 0.1
 */
public class UserStore<User> extends AbstractStore {
    final SimpleArray<User> store;

    public UserStore(SimpleArray<User> store) {
        this.store = store;
    }

    @SuppressWarnings("EmptyMethod")
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

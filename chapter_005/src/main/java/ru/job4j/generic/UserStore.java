package ru.job4j.generic;

/**
 * @author madrabit on 07.10.2019
 * @version 1$
 * @since 0.1
 */
public class UserStore<User> extends AbstractStore {
    final SimpleArray<User> store;
    public UserStore(SimpleArray<User> store) {
        super(store);
        this.store = store;
    }
}

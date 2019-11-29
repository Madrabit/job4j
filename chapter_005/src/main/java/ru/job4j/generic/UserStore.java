package ru.job4j.generic;

/**
 * @author madrabit on 07.10.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("rawtypes")
public class UserStore<User> extends AbstractStore {

    public UserStore(int size) {
        super(size);
    }
}

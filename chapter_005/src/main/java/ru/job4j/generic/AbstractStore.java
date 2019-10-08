package ru.job4j.generic;

import java.util.Iterator;

/**
 * @author madrabit on 07.10.2019
 * @version 1$
 * @since 0.1
 */
public abstract class AbstractStore<E extends Base> implements Store {
    final SimpleArray<E> store;

    protected AbstractStore(SimpleArray<E> store) {
        this.store = store;
    }

    @Override
    public void add(Base model) {
        store.add((E) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        Base target = findById(id);
        if (target == null) {
            return false;
        } else {
            Iterator it = store.iterator();
            int index = 0;
            while (it.hasNext()) {
                index++;
                if (target.equals(it.next())) {
                    break;
                }
            }
            store.set(index, (E) model);
            return true;
        }
    }

    @Override
    public boolean delete(String id) {
        Base target = findById(id);
        if (target == null) {
            return false;
        } else {
            Iterator it = store.iterator();
            int index = 0;
            while (it.hasNext()) {
                index++;
                if (target.equals(it.next())) {
                    break;
                }
            }
            store.remove(index);
            return true;
        }

    }

    @Override
    public Base findById(String id) {
        E result = null;
        for (E e : store) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }
}

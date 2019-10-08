package ru.job4j.generic;

import java.util.Iterator;

/**
 * @author madrabit on 07.10.2019
 * @version 1$
 * @since 0.1
 */
public abstract class AbstractStore<E extends Base> implements Store<E> {
    /**
     * Structure for store elements.
     */
    final SimpleArray<E> store;

    protected AbstractStore(SimpleArray<E> store) {
        this.store = store;
    }

    /**
     * Add element to store.
     * @param model Element.
     */
    @Override
    public void add(Base model) {
        store.add((E) model);
    }

    /**
     * Replace element by ID.
     * @param id Target id.
     * @param model New Element.
     * @return Result of replacing.
     */
    @Override
    public boolean replace(String id, Base model) {
        int index = findIndexById(id);
        store.set(index, (E) model);
        return index > 0 ? true : false;
    }

    /**
     * Delete element by id.
     * @param id Target id.
     * @return Deleting result.
     */
    @Override
    public boolean delete(String id) {
        int index = findIndexById(id);
        store.remove(index);
        return index > 0 ? true : false;
    }

    /**a
     * Find element by ID.
     * @param id ID.
     * @return Returning desired id.
     */
    @Override
    public E findById(String id) {
        Iterator it =  store.iterator();
        while (it.hasNext()) {
            E result = (E) it.next();
            if (result.getId().equals(id)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Find Index of Element by ID.
     * @param id ID.
     * @return Index.
     */
    @Override
    public int findIndexById(String id) {
            Iterator it = store.iterator();
            int index = 0;
            for (E e : store) {
                if (e.getId().equals(id)) {
                    return index;
                }
                index++;
            }
            return -1;
    }
}

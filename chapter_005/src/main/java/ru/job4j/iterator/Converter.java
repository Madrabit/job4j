package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author madrabit on 02.10.2019
 * @version 1$
 * @since 0.1
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        //noinspection RedundantCollectionOperation
        return new Iterator<>() {
            @SuppressWarnings("RedundantOperationOnEmptyContainer")
            private Iterator<Integer> current = (new ArrayList<Integer>()).iterator();

            @Override
            public boolean hasNext() {
                while (it.hasNext() && !current.hasNext()) {
                    current = it.next();
                }
                return current.hasNext();
            }

            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return current.next();
            }
        };
    }
}

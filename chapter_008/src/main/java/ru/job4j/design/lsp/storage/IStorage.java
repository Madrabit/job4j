package ru.job4j.design.lsp.storage;

/**
 * @author madrabit
 * Storage Interface.
 */
public interface IStorage {

    /**
     * Check food freshness
     * @param food Food.
     * @return result.
     */
    boolean accept(Food food);

    /**
     * Add to storage.
     * @param f Food.
     */
    void add(Food f);
}

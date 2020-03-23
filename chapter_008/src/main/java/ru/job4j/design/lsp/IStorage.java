package ru.job4j.design.lsp;

/**
 * @author madrabit
 */
public interface IStorage {

    boolean accept(Food food);

    void add(Food f);
}

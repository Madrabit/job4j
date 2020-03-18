package ru.job4j.design.lsp.storage;

import java.time.LocalDate;

/**
 * @author madrabit
 */
public class Fish extends Food {
    public Fish(String name, LocalDate createDate, LocalDate expiryDate, int price, int discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}

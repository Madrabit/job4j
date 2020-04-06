package ru.job4j.design.lsp.storage;

import java.time.LocalDate;

/**
 * @author madrabit
 * Food example MILK
 */
public class Milk extends Food {
    public Milk(String name, LocalDate createDate, LocalDate expiryDate, int price, int discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}

package ru.job4j.design.lsp;

import java.time.LocalDate;

/**
 * @author madrabit
 */
public class Milk extends Food {
    public Milk(String name, LocalDate createDate, LocalDate expiryDate, int price, int discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}

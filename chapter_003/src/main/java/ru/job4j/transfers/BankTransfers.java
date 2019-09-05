package ru.job4j.transfers;

import java.util.*;

/**
 * @author madrabit on 04.09.2019
 * @version 1$
 * @since 0.1
 */
public class BankTransfers {
    TreeMap<User, List<Account>> clients = new TreeMap<>();
    /**
     * добавление пользователя
     *
     * @param user
     */
    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        clients.put(user, accounts);
    }

    /**
     * удаление пользователя
     *
     * @param user
     */
    public void deleteUser(User user) {
        clients.remove(user);
    }

    /**
     * добавить счёт пользователю     *
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry el : clients.entrySet()) {
            if (el.getKey().equals(passport)) {
                clients.get(el).add(account);
            }
        }
    }

    /**
     * удалить один счёт пользователя
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry el : clients.entrySet()) {
            if (el.getKey().equals(passport)) {
                clients.get(el).remove(account);
            }
        }
    }

    /**
     * получить список счетов для пользователя
     * @param passport
     * @return
     */
    public List<Account> getUserAccounts(String passport) {
        for (Map.Entry el : clients.entrySet()) {
            if (el.getKey().equals(passport)) {
                return clients.get(el);
            } else {
                return new ArrayList<>();
            }
        }
    }
}

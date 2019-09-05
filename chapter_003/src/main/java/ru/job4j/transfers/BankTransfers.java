package ru.job4j.transfers;

import java.util.*;

/**
 * @author madrabit on 04.09.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("JavaDoc")
public class BankTransfers {
    final TreeMap<User, List<Account>> clients = new TreeMap<>();
    /**
     * добавление пользователя
     * @param user
     */
    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        if (!clients.containsKey(user)) {
            clients.put(user, accounts);
        }
    }

    /**
     * удаление пользователя
     * @param user
     */
    public void deleteUser(User user) {
        clients.remove(user);
    }

    /**
     *  метод поиска аккаунта по паспорту и реквизитам
     * @param passport
     * @param requisite
     * @return
     */
    public Account findByPassAndReq(String passport, String requisite) {
        for (Map.Entry el : clients.entrySet()) {
            if (el.getKey().equals(passport)) {
                int index = clients.get(el).indexOf(requisite);
                return clients.get(el).get(index);
            }
        }
        return new Account();
    }
    /**
     * добавить счёт пользователю
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

    /**
     * метод для перечисления денег с одного счёта на другой счёт
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param dstRequisite
     * @param amount
     * @return
     */
    public boolean transferMoney(String srcPassport,
                                  String srcRequisite,
                                  String destPassport,
                                  String dstRequisite,
                                  double amount) {
        BankTransfers transfers = new BankTransfers();
        Account sender = transfers.findByPassAndReq(srcPassport, srcRequisite);
        Account recipient = transfers.findByPassAndReq(destPassport, dstRequisite);
        if (sender != null  && recipient != null && sender.getValue() > 0) {
            recipient.setValue(amount);
            sender.setValue(sender.getValue() - amount);
            return true;
        } else {
            return false;
        }
    }
}

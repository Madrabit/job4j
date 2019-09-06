package ru.job4j.transfers;

import java.util.*;

/**
 * @author madrabit on 04.09.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("JavaDoc")
public class BankTransfers {
    final TreeMap<User, List<Account>> clients = new TreeMap<>(new Comparator<User>() {
        @Override
        public int compare(User user, User t1) {
            return 0;
        }
    });

    public TreeMap<User, List<Account>> getClients() {
        return clients;
    }

    /**
     * добавление пользователя
     * @param user
     */
    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        clients.putIfAbsent(user, accounts);
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
    public Account findByPassAndReq(String passport, int requisite) {
        if (clients.containsKey(new User("name", passport))) {
           List<Account> accounts = clients.get(new User("name", passport));
            for (Account account : accounts) {
                if (account.getRequisites() == requisite) {
                    return account;
                }
            }
           return new Account();
        }
        return new Account();
    }
    /**
     * добавить счёт пользователю
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
            if (clients.containsKey(new User("name", passport))) {
                clients.get(new User("name", passport)).add(account);
            }
    }

    /**
     * удалить один счёт пользователя
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (User el : clients.keySet()) {
            if (el.getPassport().equals(passport)) {
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
        List<Account> list = new ArrayList<>();
        for (User el : clients.keySet()) {
            if (el.getPassport().equals(passport)) {
                return clients.get(el);
            } else {
                return list;
            }
        }
        return list;
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
                                  int srcRequisite,
                                  String destPassport,
                                  int dstRequisite,
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

package ru.job4j.transfers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author madrabit on 04.09.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("JavaDoc")
public class BankTransfers {
    final Map<User, List<Account>> clients = new HashMap<>();

    public Map<User, List<Account>> getClients() {
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
        return clients.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .map(clients::get)
                .flatMap(accounts -> accounts.stream()
                        .filter(account -> account.getRequisites() == requisite)
                        .findFirst())
                .orElse(null);
    }
    /**
     * добавить счёт пользователю
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
      User user = clients.keySet()
                .stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst().orElse(null);
      clients.get(user).add(account);
    }

    /**
     * удалить один счёт пользователя
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> accounts = clients.get(new User("name", passport));
        accounts.remove(account);
    }

    /**
     * получить список счетов для пользователя
     * @param passport
     * @return
     */
    public List<Account> getUserAccounts(String passport) {
        return clients.get(new User("name", passport));
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
        Account sender = this.findByPassAndReq(srcPassport, srcRequisite);
        Account recipient = this.findByPassAndReq(destPassport, dstRequisite);
        if (sender != null  && recipient != null && sender.getValue() > 0) {
            recipient.setValue(amount);
            sender.setValue(sender.getValue() - amount);
            return true;
        } else {
            return false;
        }
    }
}

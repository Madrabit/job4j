package ru.job4j.transfers;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * @author madrabit on 06.09.2019
 * @version $
 * @since 0.1
 */

public class BankTransfersTest {
    @Test
    public void addUser() {
        BankTransfers bankTransfers = new BankTransfers();
        User user = new User("Man", "123");
        bankTransfers.addUser(user);
        User result = bankTransfers.getClients().firstKey();
        assertThat(result, is(new User("Man", "123")));
    }

    @Test
    public void deleteUser() {
        BankTransfers bankTransfers = new BankTransfers();
        User user = new User("Man", "123");
        bankTransfers.addUser(user);
        bankTransfers.deleteUser(user);
        int result = bankTransfers.clients.size();
        assertThat(result, is(0));
    }

    @Test
    public void findByPassAndReq() {
        BankTransfers bankTransfers = new BankTransfers();
        User user = new User("Man", "123");
        bankTransfers.addUser(user);
        Account account = new Account(111, 222);
        bankTransfers.addAccountToUser("123", account);
        Account result = bankTransfers.findByPassAndReq("123", 222);
        assertThat(result, is(account));
    }

    @Test
    public void addAccountToUser() {
        BankTransfers bankTransfers = new BankTransfers();
        User user = new User("Man", "123");
        bankTransfers.addUser(user);
        Account account = new Account(111, 222);
        bankTransfers.addAccountToUser("123", account);
        Account result = bankTransfers.clients.get(user).get(0);
        assertThat(result, is(account));
    }

    @Test
    public void deleteAccountFromUser() {
        BankTransfers bankTransfers = new BankTransfers();
        User user = new User("Man", "123");
        bankTransfers.addUser(user);
        Account account = new Account(111, 222);
        bankTransfers.addAccountToUser("123", account);
        bankTransfers.deleteAccountFromUser("123", account);
        boolean result = bankTransfers.clients.get(user).isEmpty();
        assertThat(result, is(true));
    }

    @Test
    public void getUserAccounts() {
        BankTransfers bankTransfers = new BankTransfers();
        User user = new User("Man", "123");
        bankTransfers.addUser(user);
        Account account = new Account(111, 222);
        bankTransfers.addAccountToUser("123", account);
        List<Account> result = bankTransfers.getUserAccounts("123");
        List<Account> expected = new ArrayList<>();
        expected.add(account);
        assertThat(result, is(expected));
    }

    @Test
    public void transferMoney() {
        BankTransfers bankTransfers = new BankTransfers();
        User user = new User("Man", "123");
        bankTransfers.addUser(user);
        Account account = new Account(100, 111);
        bankTransfers.addAccountToUser("123", account);
        User user2 = new User("Man2", "222");
        bankTransfers.addUser(user2);
        Account account2 = new Account(0, 444);
        bankTransfers.addAccountToUser("222", account2);
        boolean result = bankTransfers.transferMoney("123", 111, "222", 444, 50);
        assertThat(result, is(true));
    }
}

package com.cristian.design.patterns.state;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.cristian.design.patterns.domain.Account;

public class AccountAggregate {

  private static Map<Integer, Account> accounts = new HashMap<>();

  private AccountAggregate() {
  }

  public static void putAccount(final Account account) {
    AccountAggregate.accounts.put(account.getAccountNo(), account);
  }

  public static Account getAccount(final int accountNo) {
    return Optional.of(accountNo)
        .map(AccountAggregate.accounts::get)
        .map(Account::copy)
        .orElse(null);
  }

  public static void resetState() {
    AccountAggregate.accounts = new HashMap<>();
  }
}

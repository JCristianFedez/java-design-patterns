package com.cristian.design.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bank {

  private final Map<Integer, Account> accounts = new HashMap<>();

  public void addAccounts(final Account... accounts) {
    Stream.of(accounts).forEach(account -> this.accounts.put(account.getId(), account));
  }

  public synchronized void transfer(final int sourceAccountId, final int destinationAccountId, final int amount) {
    this.accounts.get(sourceAccountId).retireAmount(amount);
    this.accounts.get(destinationAccountId).addAmount(amount);

    LOGGER.debug("Transferred from account {} to account {} {}$, current bank balance {}", sourceAccountId, destinationAccountId, amount,
        getBalance());
  }

  private synchronized int getBalance() {
    return this.accounts.values().stream()
        .mapToInt(Account::getAmount)
        .sum();
  }
}

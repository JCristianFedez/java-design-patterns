package com.cristian.design.patterns.domain;

import java.math.BigDecimal;
import java.util.StringJoiner;

import com.cristian.design.patterns.event.AccountCreateEvent;
import com.cristian.design.patterns.event.MoneyDepositEvent;
import com.cristian.design.patterns.event.MoneyTransferEvent;
import com.cristian.design.patterns.state.AccountAggregate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Account {

  private static final String MSG = "Some external api for only realtime execution could be called here.";

  private final int accountNo;

  private final String owner;

  private BigDecimal money = BigDecimal.ZERO;

  public Account copy() {
    final Account account = new Account(this.accountNo, this.owner);
    account.setMoney(this.money);
    return account;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
        .add("accountNo=" + accountNo)
        .add("owner='" + owner + "'")
        .add("money=" + money)
        .toString();
  }

  private void depositMoney(final BigDecimal money) {
    this.money = this.money.add(money);
  }

  private void withdrawMoney(final BigDecimal money) {
    this.money = this.money.subtract(money);
  }

  private void handleDeposit(final BigDecimal money, final boolean realTime) {
    depositMoney(money);
    AccountAggregate.putAccount(this);
    if (realTime) {
      System.out.println(Account.MSG);
    }
  }

  private void handleWithdrawal(final BigDecimal money, final boolean realTime) {
    if (this.money.compareTo(money) < 0) {
      throw new RuntimeException("Insufficient Account Balance");
    }

    withdrawMoney(money);
    AccountAggregate.putAccount(this);
    if (realTime) {
      System.out.println(Account.MSG);
    }
  }

  /**
   * Handles the {@link MoneyDepositEvent}.
   */
  public void handleEvent(final MoneyDepositEvent moneyDepositEvent) {
    handleDeposit(moneyDepositEvent.getMoney(), moneyDepositEvent.isRealTime());
  }

  /**
   * Handles the {@link AccountCreateEvent}.
   */
  public void handleEvent(final AccountCreateEvent accountCreateEvent) {
    AccountAggregate.putAccount(this);
    if (accountCreateEvent.isRealTime()) {
      System.out.println(Account.MSG);
    }
  }

  /**
   * Handles transfer from account event.
   */
  public void handleTransferFromEvent(final MoneyTransferEvent moneyTransferEvent) {
    handleWithdrawal(moneyTransferEvent.getMoney(), moneyTransferEvent.isRealTime());
  }

  /**
   * Handles transfer to account event.
   */
  public void handleTransferToEvent(final MoneyTransferEvent moneyTransferEvent) {
    handleDeposit(moneyTransferEvent.getMoney(), moneyTransferEvent.isRealTime());
  }
}

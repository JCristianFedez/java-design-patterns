package com.cristian.design.patterns.event;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Optional;

import com.cristian.design.patterns.domain.Account;
import com.cristian.design.patterns.state.AccountAggregate;

import lombok.Getter;

@Getter
public class MoneyTransferEvent extends DomainEvent {

  @Serial
  private static final long serialVersionUID = 6939239282969351426L;

  private final BigDecimal money;

  private final int accountNoFrom;

  private final int accountNoTo;

  public MoneyTransferEvent(final long sequenceId, final long createdTime, final BigDecimal money, final int accountNoFrom,
      final int accountNoTo) {
    super(sequenceId, createdTime, MoneyTransferEvent.class.getSimpleName());
    this.money = money;
    this.accountNoFrom = accountNoFrom;
    this.accountNoTo = accountNoTo;
  }

  @Override
  public void process() {
    final Account accountFrom = Optional.ofNullable(AccountAggregate.getAccount(this.accountNoFrom))
        .orElseThrow(() -> new RuntimeException("Account not found " + this.accountNoFrom));
    final Account accountTo = Optional.ofNullable(AccountAggregate.getAccount(this.accountNoTo))
        .orElseThrow(() -> new RuntimeException("Account not found " + this.accountNoTo));
    accountFrom.handleTransferFromEvent(this);
    accountTo.handleTransferToEvent(this);
  }
}

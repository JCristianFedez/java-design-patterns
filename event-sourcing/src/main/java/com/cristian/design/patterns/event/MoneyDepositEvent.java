package com.cristian.design.patterns.event;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Optional;

import com.cristian.design.patterns.domain.Account;
import com.cristian.design.patterns.state.AccountAggregate;

import lombok.Getter;

@Getter
public class MoneyDepositEvent extends DomainEvent {

  @Serial
  private static final long serialVersionUID = 8469337380918347893L;

  private final int accountNo;

  private final BigDecimal money;

  public MoneyDepositEvent(final long sequenceId, final long createdTime, final int accountNo, final BigDecimal money) {
    super(sequenceId, createdTime, MoneyDepositEvent.class.getSimpleName());
    this.accountNo = accountNo;
    this.money = money;
  }

  @Override
  public void process() {
    final Account account = Optional.ofNullable(AccountAggregate.getAccount(this.accountNo))
        .orElseThrow(() -> new RuntimeException("Account not found"));
    account.handleEvent(this);
  }
}
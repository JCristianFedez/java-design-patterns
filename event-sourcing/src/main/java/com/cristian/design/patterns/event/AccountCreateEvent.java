package com.cristian.design.patterns.event;

import java.io.Serial;

import com.cristian.design.patterns.domain.Account;
import com.cristian.design.patterns.state.AccountAggregate;

import lombok.Getter;

@Getter
public class AccountCreateEvent extends DomainEvent {

  @Serial
  private static final long serialVersionUID = 1762641444048276457L;

  private final int accountNo;

  private final String owner;

  public AccountCreateEvent(final long sequenceId, final long createdTime, final int accountNo, final String owner) {
    super(sequenceId, createdTime, AccountCreateEvent.class.getSimpleName());
    this.accountNo = accountNo;
    this.owner = owner;
  }

  @Override
  public void process() {
    Account account = AccountAggregate.getAccount(this.accountNo);
    if (account != null) {
      throw new RuntimeException("Account already exists");
    }
    account = new Account(this.accountNo, this.owner);
    account.handleEvent(this);
  }
}
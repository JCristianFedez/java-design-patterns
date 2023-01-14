package com.cristian.design.patterns.app;

import java.math.BigDecimal;
import java.util.Date;

import com.cristian.design.patterns.event.AccountCreateEvent;
import com.cristian.design.patterns.event.MoneyDepositEvent;
import com.cristian.design.patterns.event.MoneyTransferEvent;
import com.cristian.design.patterns.processor.DomainEventProcessor;
import com.cristian.design.patterns.state.AccountAggregate;

public class Demo {

  private static final int ACCOUNT_OF_DAENERYS = 1;

  private static final int ACCOUNT_OF_JON = 2;

  public static void main(String[] args) {
    new Demo().run();
  }

  private void run() {
    DomainEventProcessor eventProcessor = new DomainEventProcessor();

    System.out.println("Running the system first time............");
    eventProcessor.reset();

    System.out.println("Creating the accounts............");

    eventProcessor.process(new AccountCreateEvent(0, new Date().getTime(), ACCOUNT_OF_DAENERYS, "Daenerys Targaryen"));

    eventProcessor.process(new AccountCreateEvent(1, new Date().getTime(), ACCOUNT_OF_JON, "Jon Snow"));

    System.out.println("Do some money operations............");

    eventProcessor.process(new MoneyDepositEvent(2, new Date().getTime(), ACCOUNT_OF_DAENERYS, new BigDecimal("100000")));

    eventProcessor.process(new MoneyDepositEvent(3, new Date().getTime(), ACCOUNT_OF_JON, new BigDecimal("100")));

    eventProcessor.process(new MoneyTransferEvent(4, new Date().getTime(), new BigDecimal("10000"), ACCOUNT_OF_DAENERYS, ACCOUNT_OF_JON));

    System.out.println("...............State:............");
    System.out.println(AccountAggregate.getAccount(ACCOUNT_OF_DAENERYS).toString());
    System.out.println(AccountAggregate.getAccount(ACCOUNT_OF_JON).toString());

    System.out.println("At that point system had a shut down, state in memory is cleared............");
    AccountAggregate.resetState();

    System.out.println("Recover the system by the events in journal file............");

    eventProcessor = new DomainEventProcessor();
    eventProcessor.recover();

    System.out.println("...............Recovered State:............");
    System.out.println(AccountAggregate.getAccount(ACCOUNT_OF_DAENERYS).toString());
    System.out.println(AccountAggregate.getAccount(ACCOUNT_OF_JON).toString());
  }
}

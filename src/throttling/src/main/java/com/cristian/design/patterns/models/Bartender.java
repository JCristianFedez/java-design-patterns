package com.cristian.design.patterns.models;

import java.util.concurrent.ThreadLocalRandom;

import com.cristian.design.patterns.timer.Throttler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bartender {

  private final CallsCount callsCount;

  public Bartender(final Throttler timer, final CallsCount callsCount) {
    this.callsCount = callsCount;
    timer.start();
  }

  public int orderDrink(final BarCustomer barCustomer) {
    final String tenantName = barCustomer.getName();
    final long count = this.callsCount.getCount(tenantName);
    if (count >= barCustomer.getAllowedCallsPerSecond()) {
      LOGGER.error("I'm sorry {}, you've had enought for today!", tenantName);
      return -1;
    }
    this.callsCount.incrementCount(tenantName);
    LOGGER.info("Serving beer to {} : [{} customed] ", barCustomer.getName(), count + 1);
    return getRandomCustomerId();
  }

  private int getRandomCustomerId() {
    return ThreadLocalRandom.current().nextInt(1, 10000);
  }
}

package com.cristian.design.patterns;

import java.util.concurrent.atomic.AtomicLong;

import lombok.Getter;

@Getter
public class Consumer {

  private final AtomicLong sumOfSquaredNumbers;

  public Consumer(final long init) {
    this.sumOfSquaredNumbers = new AtomicLong(init);
  }

  public void add(final long num) {
    this.sumOfSquaredNumbers.addAndGet(num);
  }
}

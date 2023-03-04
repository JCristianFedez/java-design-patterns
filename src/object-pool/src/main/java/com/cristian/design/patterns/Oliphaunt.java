package com.cristian.design.patterns;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;

public class Oliphaunt {

  private static final AtomicInteger counter = new AtomicInteger(0);

  @Getter
  private final int id;

  public Oliphaunt() {
    this.id = counter.incrementAndGet();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
      Thread.currentThread().interrupt();
    }
  }

  @Override
  public String toString() {
    return String.format("Oliphaunt id=%d", this.id);
  }
}

package com.cristian.design.patterns;

import java.security.SecureRandom;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SquareNumberRequest {

  private static final SecureRandom SECURE_RANDOM = new SecureRandom();

  private final long number;

  public void delaySquaring(final Consumer consumer) {
    final long minTimeOut = 2000L;
    final int randomTimeOut = SECURE_RANDOM.nextInt(5000);

    try {
      System.out.printf("%s processing number %s; current value is %s %n", Thread.currentThread(), this.number,
          consumer.getSumOfSquaredNumbers().get());
      Thread.sleep(minTimeOut + randomTimeOut);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    } finally {
      final long oldValue = consumer.getSumOfSquaredNumbers().get();
      consumer.add(this.number * this.number);
      System.out.printf("%s processed number %s; old value = %s; current value is %s %n", Thread.currentThread(), this.number,
          oldValue, consumer.getSumOfSquaredNumbers().get());
    }
  }
}

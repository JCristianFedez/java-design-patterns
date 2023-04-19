package com.cristian.design.patterns.retry;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import com.cristian.design.patterns.BusinessOperation;
import com.cristian.design.patterns.exceptions.BusinessException;

public class RetryExponentialBackoff<T> implements BusinessOperation<T> {

  private static final SecureRandom RANDOM = new SecureRandom();

  private final BusinessOperation<T> op;

  private final int maxAttempts;

  private final long maxDelay;

  private final AtomicInteger attempts = new AtomicInteger();

  private final Predicate<Exception> test;

  private final List<Exception> errors = new ArrayList<>();

  @SafeVarargs
  public RetryExponentialBackoff(
      final BusinessOperation<T> op,
      final int maxAttempts,
      final long maxDelay,
      final Predicate<Exception>... ignoreTests
  ) {
    this.op = op;
    this.maxAttempts = maxAttempts;
    this.maxDelay = maxDelay;
    this.test = Arrays.stream(ignoreTests).reduce(Predicate::or).orElse(e -> false);
  }

  public List<Exception> errors() {
    return Collections.unmodifiableList(this.errors);
  }

  public int attempts() {
    return this.attempts.intValue();
  }

  @Override
  public T perform() throws BusinessException {
    while (true) {
      try {
        return this.op.perform();
      } catch (BusinessException e) {
        this.errors.add(e);

        if (this.attempts.incrementAndGet() >= this.maxAttempts || !this.test.test(e)) {
          throw e;
        }

        final long testDelay = (long) Math.pow(2, this.attempts()) * 1000 + RANDOM.nextInt(1000);
        final long delay = Math.min(testDelay, this.maxDelay);
        try {
          Thread.sleep(delay);
        } catch (InterruptedException ex) {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
}

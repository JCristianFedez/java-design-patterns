package com.cristian.design.patterns.retry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import com.cristian.design.patterns.BusinessOperation;
import com.cristian.design.patterns.exceptions.BusinessException;

public class Retry<T> implements BusinessOperation<T> {

  private final BusinessOperation<T> op;

  private final int maxAttempts;

  private final long delay;

  private final AtomicInteger attempts = new AtomicInteger();

  private final Predicate<Exception> test;

  private final List<Exception> errors = new ArrayList<>();

  @SafeVarargs
  public Retry(final BusinessOperation<T> op, final int maxAttempts, final long delay, final Predicate<Exception>... ignoreTests) {
    this.op = op;
    this.maxAttempts = maxAttempts;
    this.delay = delay;
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

        try {
          Thread.sleep(this.delay);
        } catch (InterruptedException ex) {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
}

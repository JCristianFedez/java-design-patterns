package com.cristian.design.patterns;

import java.security.SecureRandom;
import java.util.concurrent.locks.LockSupport;
import java.util.function.Consumer;
import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractThreadLocal implements Runnable {

  private static final SecureRandom RANDOM = new SecureRandom();

  private static final Integer RANDOM_THREAD_PARK_START = 1_000_000_000;

  private static final Integer RANDOM_THREAD_PARK_END = 2_000_000_000;

  @Override
  public void run() {
    final long nanosToPark = RANDOM.nextInt(RANDOM_THREAD_PARK_START, RANDOM_THREAD_PARK_END);
    LockSupport.parkNanos(nanosToPark);

    LOGGER.info("{}, before value changing: {}", currentThreadName(), getter().get());
    setter().accept(RANDOM.nextInt());
  }

  protected abstract Consumer<Integer> setter();

  protected abstract Supplier<Integer> getter();

  private String currentThreadName() {
    return Thread.currentThread().getName();
  }
}

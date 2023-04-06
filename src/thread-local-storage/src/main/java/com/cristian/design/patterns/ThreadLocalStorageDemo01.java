package com.cristian.design.patterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalStorageDemo01 {

  public static void main(String[] args) throws InterruptedException {
    LOGGER.info("==== WITHOUT THREAD LOCAL ====");
    withoutThreadLocal();
    LOGGER.info("==== WITH THREAD LOCAL ====");
    withThreadLocal();
  }


  static void withoutThreadLocal() throws InterruptedException {
    final int initialValue = 1234567890;

    final int threadSize = 2;
    final ExecutorService executor = Executors.newFixedThreadPool(threadSize);

    final WithoutThreadLocal threadLocal = new WithoutThreadLocal(initialValue);
    for (int i = 0; i < threadSize; i++) {
      executor.submit(threadLocal);
    }
    executor.awaitTermination(3, TimeUnit.SECONDS);
  }

  static void withThreadLocal() throws InterruptedException {
    final int initialValue = 1234567890;

    final int threadSize = 2;
    final ExecutorService executor = Executors.newFixedThreadPool(threadSize);

    final WithThreadLocal threadLocal = new WithThreadLocal(ThreadLocal.withInitial(() -> initialValue));
    for (int i = 0; i < threadSize; i++) {
      executor.submit(threadLocal);
    }

    executor.awaitTermination(3, TimeUnit.SECONDS);
    threadLocal.remove();
  }
}
package com.cristian.design.patterns;

import java.security.SecureRandom;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MonitorDemo {

  private static final int NUMBER_OF_THREADS = 5;

  public static void main(String[] args) throws InterruptedException {
    new MonitorDemo().run();
  }

  private void run() throws InterruptedException {
    final Bank bank = new Bank();
    bank.addAccounts(
        new Account(0, 1000),
        new Account(1, 1000),
        new Account(2, 1000),
        new Account(3, 1000)
    );
    final CountDownLatch latch = new CountDownLatch(NUMBER_OF_THREADS);
    final ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    for (int i = 0; i < NUMBER_OF_THREADS; i++) {
      executor.execute(() -> runner(bank, latch));
    }

    latch.await();
    System.exit(1);
  }

  private void runner(final Bank bank, final CountDownLatch latch) {
    final SecureRandom random = new SecureRandom();
    try {
      Thread.sleep(random.nextInt(1000));
      LOGGER.info("Start transferring...");

      for (int i = 0; i < 1000000; i++) {
        bank.transfer(random.nextInt(3), random.nextInt(3), random.nextInt());
      }

      LOGGER.info("Finished transferring.");
      latch.countDown();
    } catch (InterruptedException e) {
      LOGGER.error(e.getMessage());
      Thread.currentThread().interrupt();
    }
    for (int i = 0; i < 1000000; i++) {
      bank.transfer(random.nextInt(4), random.nextInt(4), random.nextInt());
    }
  }

}

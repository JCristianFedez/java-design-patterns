package com.cristian.design.patterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReaderWriterLockDemo {

  public static void main(String[] args) throws InterruptedException {
    final ExecutorService executorService = Executors.newFixedThreadPool(10);
    final ReaderWriterLock lock = new ReaderWriterLock();

    // Start writers
    for (int i = 0; i < 5; i++) {
      final long writingTime = ThreadLocalRandom.current().nextLong(5000);
      final String name = String.format("Writer %s", i);
      executorService.submit(new Writer(name, lock.writeLock(), writingTime));
    }
    LOGGER.info("Writers added...");

    // Start readers
    for (int i = 0; i < 5; i++) {
      final long readingTime = ThreadLocalRandom.current().nextLong(10);
      final String name = String.format("Reader %s", i);
      executorService.submit(new Reader(name, lock.readLock(), readingTime));
    }
    LOGGER.info("Readers added...");

    Thread.sleep(5000L);

    // Start readers
    for (int i = 0; i < 10; i++) {
      final long readingTime = ThreadLocalRandom.current().nextLong(10);
      final String name = String.format("Reader %s", i);
      executorService.submit(new Reader(name, lock.readLock(), readingTime));
    }

    // In the system console, it can see that the read operations are executed concurrently while
    // write operations are exclusive.
    executorService.shutdown();
    executorService.awaitTermination(5, TimeUnit.SECONDS);
  }
}

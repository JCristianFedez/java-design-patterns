package com.cristian.design.patterns;

import java.util.concurrent.locks.Lock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Reader implements Runnable {

  private final String name;

  private final Lock readLock;

  private final long readingTime;

  @Override
  public void run() {
    this.readLock.lock();
    try {
      read();
    } catch (InterruptedException e) {
      LOGGER.warn(e.getMessage());
      Thread.currentThread().interrupt();
    } finally {
      this.readLock.unlock();
    }
  }

  private void read() throws InterruptedException {
    LOGGER.info("{} begin", this.name);
    Thread.sleep(this.readingTime);
    LOGGER.info("{} finish after reading {}ms", this.name, this.readingTime);
  }
}

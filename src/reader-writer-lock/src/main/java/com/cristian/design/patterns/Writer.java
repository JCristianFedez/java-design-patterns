package com.cristian.design.patterns;

import java.util.concurrent.locks.Lock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Writer implements Runnable {

  private final String name;

  private final Lock writeLock;

  private final long writingTime;

  @Override
  public void run() {
    this.writeLock.lock();
    try {
      write();
    } catch (InterruptedException e) {
      LOGGER.warn(e.getMessage());
      Thread.currentThread().interrupt();
    } finally {
      this.writeLock.unlock();
    }
  }

  private void write() throws InterruptedException {
    LOGGER.info("{} begin", this.name);
    Thread.sleep(this.writingTime);
    LOGGER.info("{} finish after writing {}ms", this.name, this.writingTime);
  }
}

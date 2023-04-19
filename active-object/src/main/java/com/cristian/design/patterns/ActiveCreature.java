package com.cristian.design.patterns;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
abstract class ActiveCreature {

  private final BlockingQueue<Runnable> request;

  private final String name;

  protected ActiveCreature(final String name) {
    this.name = name;
    this.request = new LinkedBlockingQueue<>();
    Thread thread = new Thread(() -> {
      while (true) {
        try {
          this.request.take().run();
        } catch (InterruptedException e) {
          LOGGER.trace("Thrown", e);
          Thread.currentThread().interrupt();
        }
      }
    });
    thread.start();
  }

  public void eat() throws InterruptedException {
    this.request.put(() -> {
      LOGGER.info("{} is eating!", getName());
      LOGGER.info("{} has finished eating!", getName());
    });
  }

  public void roam() throws InterruptedException {
    this.request.put(() -> LOGGER.info("{} has started to roam the wastelands", getName()));
  }

  public String getName() {
    return this.name;
  }
}

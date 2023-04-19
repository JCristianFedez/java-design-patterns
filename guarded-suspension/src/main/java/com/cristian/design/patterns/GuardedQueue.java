package com.cristian.design.patterns;

import java.util.LinkedList;
import java.util.Queue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuardedQueue {

  private final Queue<Integer> sourceList = new LinkedList<>();

  public synchronized Integer poll() {
    while (this.sourceList.isEmpty()) {
      LOGGER.info("Waiting");
      try {
        wait();
      } catch (InterruptedException e) {
        LOGGER.error(e.getMessage());
        Thread.currentThread().interrupt();
      }
    }

    final Integer poll = this.sourceList.poll();
    LOGGER.info("Getting {}", poll);
    return poll;
  }

  public synchronized void put(final Integer element) {
    LOGGER.info("Putting {}", element);
    this.sourceList.add(element);
    LOGGER.info("Notifying");
    notifyAll();
  }
}

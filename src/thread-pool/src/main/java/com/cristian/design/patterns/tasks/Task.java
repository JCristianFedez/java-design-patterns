package com.cristian.design.patterns.tasks;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;

@Getter
public abstract class Task {

  private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

  private final int id;

  private final int timeMs;

  protected Task(final int timeMs) {
    this.id = ID_GENERATOR.getAndIncrement();
    this.timeMs = timeMs;
  }

  @Override
  public String toString() {
    return String.format("ID: %d; timeMs:%d", this.id, this.timeMs);
  }
}

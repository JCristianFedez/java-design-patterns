package com.cristian.design.patterns;

import java.util.concurrent.TimeUnit;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Event implements IEvent, Runnable {

  private final int eventId;

  private final int eventTime;

  @Getter
  private final boolean synchronous;

  private boolean isComplete = false;

  private Thread thread;

  private ThreadCompleteListener eventListener;

  @Override
  public void start() {
    this.thread = new Thread(this);
    this.thread.start();
  }

  @Override
  public void stop() {
    if (this.thread != null) {
      this.thread.interrupt();
    }
  }

  @Override
  public void status() {
    if (!this.isComplete) {
      System.out.printf("[{}] is not done.%n", this.eventId);
    } else {
      System.out.printf("[{}] is done.%n", this.eventId);
    }
  }

  @Override
  public void run() {
    final long currentTimeMillis = System.currentTimeMillis();
    final long endTime = currentTimeMillis + (this.eventTime * 1000L);
    while (System.currentTimeMillis() < endTime) {
      try {
        Thread.sleep(TimeUnit.SECONDS.toMillis(1L));
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return;
      }
    }

    this.isComplete = true;
    completed();
  }

  public final void setListener(final ThreadCompleteListener listener) {
    this.eventListener = listener;
  }

  public final void removeListener() {
    this.eventListener = null;
  }

  private void completed() {
    if (this.eventListener != null) {
      this.eventListener.completedEventHandler(this.eventId);
    }
  }
}

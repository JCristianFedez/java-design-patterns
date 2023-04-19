package com.cristian.design.patterns;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BallThread extends Thread {

  @Setter
  private BallItem twin;

  private volatile boolean isSuspended;

  private volatile boolean isRunning = true;

  @Override
  public void run() {
    while (this.isRunning) {
      if (!this.isSuspended) {
        this.twin.draw();
        this.twin.move();
      }
      LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(250L));
    }
  }

  public void suspendMe() {
    this.isSuspended = true;
    LOGGER.info("Being to suspend BallThread");
  }

  public void resumeMe() {
    this.isSuspended = false;
    LOGGER.info("Begin to resume BallThread");
  }

  public void stopMe() {
    this.isRunning = false;
    this.isSuspended = true;
  }
}


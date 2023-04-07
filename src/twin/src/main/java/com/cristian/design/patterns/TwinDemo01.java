package com.cristian.design.patterns;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwinDemo01 {

  public static void main(String[] args) {
    final BallItem ballItem = new BallItem();
    final BallThread ballThread = new BallThread();

    ballItem.setTwin(ballThread);
    ballThread.setTwin(ballItem);

    LOGGER.info("=== START ===");
    ballThread.start();
    waiting();

    LOGGER.info("=== CLICK ===");
    ballItem.click();
    waiting();

    LOGGER.info("=== CLICK ===");
    ballItem.click();
    waiting();

    LOGGER.info("=== STOP ===");
    ballThread.stopMe();
  }

  private static void waiting() {
    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(750));
  }
}

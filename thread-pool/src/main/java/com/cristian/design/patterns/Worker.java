package com.cristian.design.patterns;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import com.cristian.design.patterns.tasks.Task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Worker implements Runnable {

  private final Task task;

  @Override
  public void run() {
    LOGGER.info("{} processing {}", Thread.currentThread().getName(), this.task.toString());
    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(this.task.getTimeMs()));
  }
}

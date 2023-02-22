package com.cristian.design.patterns.task;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaskHandler {

  public void handleTask(final Task task) throws InterruptedException {
    final int time = task.getTime();
    Thread.sleep(time);
    LOGGER.info("It takes {} milliseconds to finish the task", time);
    task.setFinished(true);
  }
}

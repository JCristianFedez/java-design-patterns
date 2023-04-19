package com.cristian.design.patterns.task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TaskSet {

  private final BlockingQueue<Task> queue = new ArrayBlockingQueue<>(100);

  public void addTask(final Task task) throws InterruptedException {
    this.queue.put(task);
  }

  public Task getTask() throws InterruptedException {
    return this.queue.take();
  }

  public int getSize() {
    return this.queue.size();
  }
}

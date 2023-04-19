package com.cristian.design.patterns.worker;

import com.cristian.design.patterns.task.Task;
import com.cristian.design.patterns.task.TaskHandler;
import com.cristian.design.patterns.task.TaskSet;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Worker implements Runnable {

  @EqualsAndHashCode.Include
  private final long id;

  private final WorkCenter workCenter;

  private final TaskSet taskSet;

  private final TaskHandler taskHandler;

  public Worker(final int id, final WorkCenter workCenter, final TaskSet taskSet, final TaskHandler taskHandler) {
    this.id = id;
    this.workCenter = workCenter;
    this.taskSet = taskSet;
    this.taskHandler = taskHandler;
  }

  @Override
  public void run() {
    while (!Thread.interrupted()) {
      try {
        if (this.workCenter.getLeader() != null && !this.workCenter.getLeader().equals(this)) {
          synchronized (this.workCenter) {
            if (this.workCenter.getLeader() != null && !this.workCenter.getLeader().equals(this)) {
              this.workCenter.wait();
              continue;
            }
          }
        }
        final Task task = this.taskSet.getTask();
        synchronized (this.workCenter) {
          this.workCenter.removeWorker(this);
          this.workCenter.promoteLeader();
          this.workCenter.notifyAll();
        }
        this.taskHandler.handleTask(task);
        LOGGER.info("The Worker with the ID {} completed the task", this.id);
        this.workCenter.addWorker(this);
      } catch (final InterruptedException e) {
        LOGGER.warn("Worker interrupted");
        Thread.currentThread().interrupt();
        return;
      }
    }
  }
}

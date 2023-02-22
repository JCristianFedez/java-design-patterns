package com.cristian.design.patterns.worker;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.cristian.design.patterns.task.TaskHandler;
import com.cristian.design.patterns.task.TaskSet;

import lombok.Getter;

public class WorkCenter {

  @Getter
  private final List<Worker> workers = new CopyOnWriteArrayList<>();

  @Getter
  private Worker leader;

  public void createWorkers(final int quantity, final TaskSet taskSet, final TaskHandler handler) {
    for (int i = 1; i <= quantity; i++) {
      final Worker worker = new Worker(i, this, taskSet, handler);
      this.workers.add(worker);
    }
    promoteLeader();
  }

  public void addWorker(final Worker worker) {
    this.workers.add(worker);
  }

  public void removeWorker(final Worker worker) {
    this.workers.remove(worker);
  }

  public void promoteLeader() {
    this.leader = this.workers.stream().findFirst().orElse(null);
  }

}

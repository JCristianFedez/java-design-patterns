package com.cristian.design.patterns;

import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.cristian.design.patterns.task.Task;
import com.cristian.design.patterns.task.TaskHandler;
import com.cristian.design.patterns.task.TaskSet;
import com.cristian.design.patterns.worker.WorkCenter;
import com.cristian.design.patterns.worker.Worker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeaderFollowersDemo {

  public static void main(String[] args) throws InterruptedException {
    new LeaderFollowersDemo().run();
  }

  private void run() throws InterruptedException {
    final TaskSet taskSet = new TaskSet();
    final TaskHandler taskHandler = new TaskHandler();
    final WorkCenter workCenter = new WorkCenter();
    workCenter.createWorkers(4, taskSet, taskHandler);
    execute(workCenter, taskSet);
  }

  private void execute(final WorkCenter workCenter, final TaskSet taskSet) throws InterruptedException {
    final List<Worker> workers = workCenter.getWorkers();
    final ExecutorService exec = Executors.newFixedThreadPool(workers.size());
    workers.forEach(exec::submit);
    Thread.sleep(1000);
    addTasks(taskSet);
    exec.awaitTermination(2, TimeUnit.SECONDS);
    exec.shutdown();
  }

  private void addTasks(final TaskSet taskSet) throws InterruptedException {
    final SecureRandom random = new SecureRandom();
    for (int i = 0; i < 5; i++) {
      final int time = Math.abs(random.nextInt(1000));
      taskSet.addTask(new Task(time));
    }
  }
}

package com.cristian.design.patterns;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cristian.design.patterns.tasks.CoffeeMakingTask;
import com.cristian.design.patterns.tasks.PotatoPeelingTask;
import com.cristian.design.patterns.tasks.Task;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadPoolDemo01 {

  public static void main(String[] args) {
    LOGGER.info("Program started");

    final List<Task> tasks = List.of(
        new PotatoPeelingTask(3),
        new PotatoPeelingTask(6),
        new CoffeeMakingTask(2),
        new CoffeeMakingTask(6),
        new PotatoPeelingTask(4),
        new CoffeeMakingTask(2),
        new PotatoPeelingTask(4),
        new CoffeeMakingTask(9),
        new PotatoPeelingTask(3),
        new CoffeeMakingTask(2),
        new PotatoPeelingTask(4),
        new CoffeeMakingTask(2),
        new CoffeeMakingTask(7),
        new PotatoPeelingTask(4),
        new PotatoPeelingTask(5)
    );

    final ExecutorService executor = Executors.newFixedThreadPool(3);

    tasks.stream().map(Worker::new).forEach(executor::execute);

    executor.shutdown();
    while (!executor.isTerminated()) {
      Thread.yield();
    }
    LOGGER.info("Program finished");
  }
}

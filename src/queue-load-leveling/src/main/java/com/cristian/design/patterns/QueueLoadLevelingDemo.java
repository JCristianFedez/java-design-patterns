package com.cristian.design.patterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.cristian.design.patterns.message.MessageQueue;
import com.cristian.design.patterns.task.TaskGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueueLoadLevelingDemo {

  private static final int SHUTDOWN_TIME = 15;

  public static void main(String[] args) throws InterruptedException {
    final MessageQueue msgQueue = new MessageQueue();

    LOGGER.info("Submitting TaskGenerators and ServiceExecutor threads");

    // Create three TaskGenerator threads. Each of them will submit different number of jobs.
    final TaskGenerator taskRunnable1 = new TaskGenerator(msgQueue, 5);
    final TaskGenerator taskRunnable2 = new TaskGenerator(msgQueue, 1);
    final TaskGenerator taskRunnable3 = new TaskGenerator(msgQueue, 2);

    // Create e service which should process the submitted jobs.
    final ServiceExecutor srvRunnable = new ServiceExecutor(msgQueue);

    // Create a ThreadPool of 2 threads and submit all Runnable task for execution to executor..
    final ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.submit(taskRunnable1);
    executor.submit(taskRunnable2);
    executor.submit(taskRunnable3);

    // submitting serviceExecutor thread to the Executor service.
    executor.submit(srvRunnable);

    // Initiates an orderly shutdown.
    LOGGER.info("Initiating shutdown. Executor will shutdown only after all the Threads are completed.");
    executor.shutdown();

    // Wait for SHUTDOWN_TIME seconds for all the threads to complete their tasks and then shut down the executor and then exit.
    if (!executor.awaitTermination(SHUTDOWN_TIME, TimeUnit.SECONDS)) {
      LOGGER.info("Executor was shut down and Exiting.");
      executor.shutdownNow();
    }

  }
}

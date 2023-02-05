package com.cristian.design.patterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GuardedSuspensionDemo {

  public static void main(String[] args) throws InterruptedException {
    new GuardedSuspensionDemo().run();
  }

  private void run() throws InterruptedException {
    final GuardedQueue guardedQueue = new GuardedQueue();
    final ExecutorService executorService = Executors.newFixedThreadPool(3);

    // Here we create first thread which is supposed to get from guardedQueue
    executorService.execute(guardedQueue::poll);

    // Here we wait two seconds to show that the thread which is trying to get from guardedQueue will be waiting
    Thread.sleep(2000);

    // Now we execute second thread which will put number to guardedQueue and notify the first thread that it could get
    executorService.execute(() -> guardedQueue.put(20));
    executorService.shutdown();

    executorService.awaitTermination(30, TimeUnit.SECONDS);
  }
}

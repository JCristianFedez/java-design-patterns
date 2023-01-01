package com.cristian.design.patterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class Demo {

  public static void main(String[] args) {
    new Demo().run();
  }

  private void run() {
    final Inventory inventory = new Inventory(1000);
    final ExecutorService executorService = Executors.newFixedThreadPool(3);
    IntStream.range(0, 3).<Runnable>mapToObj(i -> () -> {
      while (inventory.addItem(new Item())) {
        System.out.println("Adding another item");
      }
    }).forEach(executorService::execute);
    executorService.shutdown();

    try {
      executorService.awaitTermination(5, TimeUnit.SECONDS);
    } catch (final InterruptedException e) {
      System.out.println("Error waiting for ExecutorService shutdown");
      Thread.currentThread().interrupt();
    }

    System.exit(0);
  }
}

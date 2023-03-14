package com.cristian.design.patterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProducerConsumerDemo {

  public static void main(String[] args) throws InterruptedException {
    final ItemQueue queue = new ItemQueue();

    final ExecutorService executorService = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 2; i++) {
      final Producer producer = new Producer("Producer_" + i, queue);
      executorService.submit(() -> {
        while (true) {
          producer.producer();
        }
      });
    }

    for (int i = 0; i < 3; i++) {
      final Consumer consumer = new Consumer("Consumer_" + i, queue);
      executorService.submit(() -> {
        while (true) {
          consumer.consume();
        }
      });
    }

    executorService.shutdown();
    executorService.awaitTermination(10, TimeUnit.SECONDS);
    executorService.shutdownNow();
  }
}

package com.cristian.design.patterns;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FanOutFanIn {

  private FanOutFanIn() {
  }

  public static long fanOutFanIn(final List<SquareNumberRequest> requests, final Consumer consumer) {
    final ExecutorService service = Executors.newFixedThreadPool(requests.size());
    final List<CompletableFuture<Void>> futures = requests.stream()
        .map(request -> CompletableFuture.runAsync(() -> request.delaySquaring(consumer), service))
        .toList();

    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

    return consumer.getSumOfSquaredNumbers().get();
  }
}

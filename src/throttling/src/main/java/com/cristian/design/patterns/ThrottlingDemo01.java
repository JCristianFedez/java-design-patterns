package com.cristian.design.patterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.IntStream;

import com.cristian.design.patterns.models.BarCustomer;
import com.cristian.design.patterns.models.Bartender;
import com.cristian.design.patterns.models.CallsCount;
import com.cristian.design.patterns.timer.ThrottleTimerImpl;
import com.cristian.design.patterns.timer.Throttler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThrottlingDemo01 {

  public static void main(String[] args) {
    final CallsCount callsCount = new CallsCount();
    final BarCustomer human = new BarCustomer("Young human", 2, callsCount);
    final BarCustomer dwarf = new BarCustomer("Dwarf soldier", 4, callsCount);

    final ExecutorService executorService = Executors.newFixedThreadPool(2);

    executorService.execute(() -> makeServiceCalls(human, callsCount));
    executorService.execute(() -> makeServiceCalls(dwarf, callsCount));

    executorService.shutdown();
    try {
      if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
        executorService.shutdownNow();
      }
    } catch (InterruptedException e) {
      executorService.shutdownNow();
      Thread.currentThread().interrupt();
    }
  }

  private static void makeServiceCalls(final BarCustomer barCustomer, final CallsCount callsCount) {
    final Throttler timer = new ThrottleTimerImpl(1000, callsCount);
    final Bartender service = new Bartender(timer, callsCount);

    IntStream.range(0, 50).forEach(i -> {
      service.orderDrink(barCustomer);
      LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100));
    });
  }
}

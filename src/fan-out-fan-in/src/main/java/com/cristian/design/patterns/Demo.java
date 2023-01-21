package com.cristian.design.patterns;

import java.util.List;

public class Demo {

  public static void main(String[] args) {
    new Demo().run();
  }

  private void run() {
    final List<Long> numbers = List.of(1L, 3L, 4L, 7L, 8L);
    System.out.printf("Numbers to be squared and get sum -> %s%n", numbers);

    final List<SquareNumberRequest> requests = numbers.stream().map(SquareNumberRequest::new).toList();
    final Consumer consumer = new Consumer(0L);
    final long sumOfSquaredNumbers = FanOutFanIn.fanOutFanIn(requests, consumer);
    System.out.printf("Sum of all squared numbers -> %s%n", sumOfSquaredNumbers);
  }
}

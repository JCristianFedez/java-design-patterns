package com.cristian.design.patterns;

import java.security.SecureRandom;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Producer {

  private static final SecureRandom RANDOM = new SecureRandom();

  private final String name;

  private final ItemQueue queue;

  private int itemId = 1;

  public void producer() throws InterruptedException {
    final Item item = new Item(this.name, this.itemId++);
    this.queue.put(item);
    Thread.sleep(RANDOM.nextInt(2000));
  }
}

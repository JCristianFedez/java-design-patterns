package com.cristian.design.patterns;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ItemQueue {
  private final BlockingQueue<Item> queue = new LinkedBlockingQueue<>(5);

  public void put(final Item item) throws InterruptedException {
    this.queue.put(item);
  }

  public Item take() throws InterruptedException {
    return this.queue.take();
  }
}

package com.cristian.design.patterns;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Consumer {

  private final String name;

  private final ItemQueue queue;

  public void consume() throws InterruptedException {
    final Item item = this.queue.take();
    LOGGER.info("Consumer [{}] consume item [{}] produced by [{}]", this.name, item.id(), item.producer());
  }
}

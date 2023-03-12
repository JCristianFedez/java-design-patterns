package com.cristian.design.patterns;

import com.cristian.design.patterns.queue.QueueManager;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Worker {

  private final QueueManager queueManager;

  @SuppressWarnings("squid:S2189")
  public void run() throws InterruptedException {
    while (true) {
      final Message message = this.queueManager.receiveMessage();
      if (message == null) {
        LOGGER.info("No Message ... waiting");
        Thread.sleep(2000);
      } else {
        processMessage(message);
      }
    }
  }

  private void processMessage(final Message message) {
    LOGGER.info(message.toString());
  }
}

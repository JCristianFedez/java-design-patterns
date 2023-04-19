package com.cristian.design.patterns;

import com.cristian.design.patterns.message.Message;
import com.cristian.design.patterns.message.MessageQueue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ServiceExecutor implements Runnable {

  private final MessageQueue msgQueue;

  @Override
  public void run() {
    while (!Thread.currentThread().isInterrupted()) {
      final Message msg = this.msgQueue.retrieveMsg();

      if (msg != null) {
        LOGGER.info("{} is served.", msg);
      } else {
        LOGGER.info("Service Executor: Waiting for Messages to serve ..");
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        LOGGER.error(e.getMessage());
        Thread.currentThread().interrupt();
      }
    }
  }
}

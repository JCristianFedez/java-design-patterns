package com.cristian.design.patterns;

import com.cristian.design.patterns.message.Message;
import com.cristian.design.patterns.message.Message.Headers;
import com.cristian.design.patterns.message.queue.MqSuscribePoint;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Consumer {

  private final String name;

  private final MqSuscribePoint queue;

  public void consume() {
    while (true) {
      final Message msg;

      try {
        msg = this.queue.take();
      } catch (InterruptedException e) {
        LOGGER.error("Exception caught.", e);
        Thread.currentThread().interrupt();
        return;
      }

      if (Message.POISON_PILL.equals(msg)) {
        LOGGER.info("Consumer {} receive request to terminate.", this.name);
        break;
      }
      final String sender = msg.getHeader(Headers.SENDER);
      final String body = msg.getBody();
      LOGGER.info("Message [{}] from [{}] received by [{}]", body, sender, this.name);
    }
  }
}

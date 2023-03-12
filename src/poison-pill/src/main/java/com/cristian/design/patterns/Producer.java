package com.cristian.design.patterns;

import java.util.Date;

import com.cristian.design.patterns.message.Message;
import com.cristian.design.patterns.message.Message.Headers;
import com.cristian.design.patterns.message.SimpleMessage;
import com.cristian.design.patterns.message.queue.MqPublishPoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Producer {

  private final String name;

  private final MqPublishPoint queue;

  private boolean isStopped;

  public void send(final String body) {
    checkIsStopped(body);
    final Message msg = new SimpleMessage();
    msg.addHeader(Headers.DATE, new Date().toString());
    msg.addHeader(Headers.SENDER, this.name);
    msg.setBody(body);

    putMsgToQueue(msg);
  }

  public void stop() {
    this.isStopped = true;
    putMsgToQueue(Message.POISON_PILL);
  }

  private void checkIsStopped(final String body) {
    if (this.isStopped) {
      final String exceptionMsg = String.format("Producer %s was stopped and fail to deliver requested message [%s].", body, this.name);
      throw new IllegalStateException(exceptionMsg);
    }
  }

  private void putMsgToQueue(final Message msg) {
    try {
      this.queue.put(msg);
    } catch (InterruptedException e) {
      LOGGER.error("Exception caught.", e);
      Thread.currentThread().interrupt();
    }
  }
}

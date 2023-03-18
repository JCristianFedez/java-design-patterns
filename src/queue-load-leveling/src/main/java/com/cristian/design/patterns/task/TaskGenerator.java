package com.cristian.design.patterns.task;

import com.cristian.design.patterns.message.Message;
import com.cristian.design.patterns.message.MessageQueue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TaskGenerator implements Task, Runnable {

  private final MessageQueue msgQueue;

  private final int msgCount;

  @Override
  public void submit(final Message msg) {
    this.msgQueue.submitMsg(msg);
  }

  @Override
  public void run() {
    int currentCount = this.msgCount;
    while (currentCount > 0) {
      final String statusMsg = String.format("Message-%s submitted by %s", currentCount, Thread.currentThread().getName());
      this.submit(new Message(statusMsg));

      LOGGER.info(statusMsg);
      currentCount--;

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        LOGGER.error(e.getMessage());
        Thread.currentThread().interrupt();
      }
    }
  }
}

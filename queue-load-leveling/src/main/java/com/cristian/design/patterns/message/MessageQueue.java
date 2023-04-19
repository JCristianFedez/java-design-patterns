package com.cristian.design.patterns.message;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessageQueue {

  private final BlockingQueue<Message> blkQueue = new ArrayBlockingQueue<>(1024);

  public void submitMsg(final Message msg) {
    if (msg != null) {
      this.blkQueue.add(msg);
    }
  }

  public Message retrieveMsg() {
    return this.blkQueue.poll();
  }
}

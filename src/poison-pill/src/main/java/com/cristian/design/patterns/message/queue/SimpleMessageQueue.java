package com.cristian.design.patterns.message.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.cristian.design.patterns.message.Message;

public class SimpleMessageQueue implements MessageQueue {

  private final BlockingQueue<Message> queue;

  public SimpleMessageQueue(final int bound) {
    this.queue = new ArrayBlockingQueue<>(bound);
  }

  @Override
  public void put(final Message msg) throws InterruptedException {
    this.queue.put(msg);
  }

  @Override
  public Message take() throws InterruptedException {
    return this.queue.take();
  }
}

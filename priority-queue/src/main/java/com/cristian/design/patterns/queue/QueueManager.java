package com.cristian.design.patterns.queue;

import com.cristian.design.patterns.Message;

public class QueueManager {

  private final PriorityMessageQueue<Message> messagePriorityMessageQueue;

  public QueueManager(final int initialCapacity) {
    this.messagePriorityMessageQueue = new PriorityMessageQueue<>(new Message[initialCapacity]);
  }

  public void publishMessage(final Message message) {
    this.messagePriorityMessageQueue.add(message);
  }

  public Message receiveMessage() {
    if (this.messagePriorityMessageQueue.isEmpty()) {
      return null;
    }
    return messagePriorityMessageQueue.remove();
  }
}

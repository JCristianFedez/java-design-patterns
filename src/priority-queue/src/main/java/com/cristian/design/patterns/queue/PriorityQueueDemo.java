package com.cristian.design.patterns.queue;

import com.cristian.design.patterns.Message;
import com.cristian.design.patterns.Worker;

public class PriorityQueueDemo {

  public static void main(String[] args) throws InterruptedException {
    final QueueManager queueManager = new QueueManager(10);

    // push some message to queue
    // Low Priority message
    for (var i = 0; i < 10; i++) {
      queueManager.publishMessage(new Message("Low Message Priority", 0));
    }

    // High Priority message
    for (var i = 0; i < 10; i++) {
      queueManager.publishMessage(new Message("High Message Priority", 1));
    }

    new Worker(queueManager).run();
  }
}

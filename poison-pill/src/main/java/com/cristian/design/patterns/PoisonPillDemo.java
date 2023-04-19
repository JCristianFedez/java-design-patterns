package com.cristian.design.patterns;

import com.cristian.design.patterns.message.queue.MessageQueue;
import com.cristian.design.patterns.message.queue.SimpleMessageQueue;

public class PoisonPillDemo {

  public static void main(String[] args) {
    final MessageQueue queue = new SimpleMessageQueue(10000);

    final Producer producer = new Producer("PRODUCER_1", queue);
    final Consumer consumer = new Consumer("CONSUMER_1", queue);

    new Thread(consumer::consume).start();

    new Thread(() -> {
      producer.send("Hand shake");
      producer.send("Some very important information");
      producer.send("Bye!");
      producer.stop();
    }).start();
  }
}

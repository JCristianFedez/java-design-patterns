package com.cristian.design.patterns.message.queue;

import com.cristian.design.patterns.message.Message;

public interface MqPublishPoint {

  void put(Message msg) throws InterruptedException;
}

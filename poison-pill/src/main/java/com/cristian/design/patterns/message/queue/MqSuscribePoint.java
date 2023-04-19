package com.cristian.design.patterns.message.queue;

import com.cristian.design.patterns.message.Message;

public interface MqSuscribePoint {

  Message take() throws InterruptedException;
}

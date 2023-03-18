package com.cristian.design.patterns.task;

import com.cristian.design.patterns.message.Message;

public interface Task {
  void submit(Message msg);
}

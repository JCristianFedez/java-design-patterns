package com.cristian.design.patterns.members;

import java.util.ArrayList;
import java.util.List;

import com.cristian.design.patterns.data.DataType;
import com.cristian.design.patterns.data.MessageData;

public class MessageCollectorMember implements Member {

  private final String name;

  private final List<String> messages = new ArrayList<>();

  public MessageCollectorMember(final String name) {
    this.name = name;
  }

  @Override
  public void accept(final DataType data) {
    if (data instanceof MessageData) {
      handleEvent((MessageData) data);
    }
  }

  private void handleEvent(MessageData data) {
    System.out.printf("{} sees message {}%n", this.name, data.getMessage());
    this.messages.add(data.getMessage());
  }

  public List<String> getMessages() {
    return new ArrayList<>(this.messages);
  }
}

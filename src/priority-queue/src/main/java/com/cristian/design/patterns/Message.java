package com.cristian.design.patterns;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Message implements Comparable<Message> {

  private final String msg;

  private final int priority;

  @Override
  public int compareTo(final Message o) {
    return this.priority - o.priority;
  }
}

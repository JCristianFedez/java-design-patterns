package com.cristian.design.patterns.commands;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandHistory {

  private final Deque<Command> history = new ArrayDeque<>();

  public void push(final Command command) {
    this.history.push(command);
  }

  public Command pop() {
    return this.history.pop();
  }

  public boolean isEmpty() {
    return this.history.isEmpty();
  }
}

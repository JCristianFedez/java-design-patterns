package com.cristian.design.patterns.example2;

import java.util.Deque;
import java.util.LinkedList;

public class Wizard {

  private final Deque<Runnable> undoStack = new LinkedList<>();

  private final Deque<Runnable> redoStack = new LinkedList<>();

  public void castSpell(final Runnable runnable) {
    runnable.run();
    this.undoStack.offerLast(runnable);
  }

  public void undoLastSpell() {
    if (this.undoStack.isEmpty()) {
      return;
    }

    final Runnable previousSpell = this.undoStack.pollLast();
    this.redoStack.offerLast(previousSpell);
    previousSpell.run();
  }

  public void redoLastSpell() {
    if (this.redoStack.isEmpty()) {
      return;
    }

    final Runnable previousUndoSpell = this.redoStack.pollLast();
    this.undoStack.offerLast(previousUndoSpell);
    previousUndoSpell.run();
  }

  @Override
  public String toString() {
    return "Wizard";
  }
}

package com.cristian.design.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Caretaker {

  private final List<Memento> savedObjects = new ArrayList<>();

  public void addMemento(final Memento... mementos) {
    this.savedObjects.addAll(Arrays.asList(mementos));
  }

  public Memento getMemento(final int index) {
    return this.savedObjects.get(index);
  }
}

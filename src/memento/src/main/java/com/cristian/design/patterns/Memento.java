package com.cristian.design.patterns;

public class Memento {

  private final String state;

  public Memento(final String state) {
    this.state = state;
  }

  public String getSavedState() {
    return state;
  }
}

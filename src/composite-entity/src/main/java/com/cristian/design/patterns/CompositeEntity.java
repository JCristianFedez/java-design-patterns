package com.cristian.design.patterns;

import java.util.Arrays;
import java.util.List;

class CompositeEntity {

  private final ConsoleCoarseGrainedObject console = new ConsoleCoarseGrainedObject();

  public void setData(String message, String signal) {
    console.setData(Arrays.asList(message, signal));
  }

  public List<String> getData() {
    return console.getData();
  }

  public void init() {
    this.console.init();
  }
}

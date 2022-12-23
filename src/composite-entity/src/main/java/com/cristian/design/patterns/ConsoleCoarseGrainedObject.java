package com.cristian.design.patterns;

import java.util.Arrays;
import java.util.List;

class ConsoleCoarseGrainedObject extends CoarseGrainedObject<String> {

  @Override
  public List<String> getData() {
    super.getData();
    return Arrays.asList(this.dependentObjects.get(0).getData(), this.dependentObjects.get(1).getData());
  }

  public void init() {
    this.dependentObjects = Arrays.asList(new MessageDependentObject(), new SignalDependentObject());
  }
}

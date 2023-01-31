package com.cristian.design.patterns.components.engine;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EngineManager {

  private final Engine engine;

  public EngineManager(final Engine engine) {
    this.engine = engine;
  }

  public void go(final double mileage) {
    if (this.engine.isStarted()) {
      this.engine.setMileage(this.engine.getMileage() + mileage);
    } else {
      LOGGER.warn("Cannot go(), you must start engine first");
    }
  }
}

package com.cristian.design.patterns.components.engine;

import com.cristian.design.patterns.logger.Logger;

public class EngineManager {

  private static final Logger LOGGER = Logger.fromType(EngineManager.class);

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

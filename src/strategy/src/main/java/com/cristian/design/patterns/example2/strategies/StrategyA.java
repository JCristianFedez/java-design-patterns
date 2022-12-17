package com.cristian.design.patterns.example2.strategies;

import com.cristian.design.patterns.logger.Logger;

public class StrategyA implements Strategy {
  private static final Logger LOGGER = Logger.fromType(StrategyA.class);

  @Override
  public void execute() {
    LOGGER.debug("Ejecutada estrategia A");
  }
}

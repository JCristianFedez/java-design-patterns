package com.cristian.design.patterns.example2.strategies;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyA implements Strategy {

  @Override
  public void execute() {
    LOGGER.debug("Ejecutada estrategia A");
  }
}

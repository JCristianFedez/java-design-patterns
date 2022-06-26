package strategy.example2.strategies;

import commons.logger.Logger;

public class StrategyA implements Strategy {
  private static final Logger LOGGER = Logger.fromType(StrategyA.class);

  @Override
  public void execute() {
    LOGGER.debug("Ejecutada estrategia A");
  }
}

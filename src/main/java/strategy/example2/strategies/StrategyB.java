package strategy.example2.strategies;

import commons.logger.Logger;

public class StrategyB implements Strategy {

  private static final Logger LOGGER = Logger.fromType(StrategyB.class);

  @Override
  public void execute() {
    LOGGER.debug("Ejecutada estrategia B");
  }
}

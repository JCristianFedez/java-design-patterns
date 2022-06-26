package strategy.example2.context;

import strategy.example2.strategies.Strategy;
import strategy.example2.strategies.StrategyA;

public class Context {

  private final Strategy strategy;

  public Context() {
    this.strategy = new StrategyA();
  }

  public Context(final Strategy strategy) {
    this.strategy = strategy;
  }

  public void execute() {
    this.strategy.execute();
  }
}

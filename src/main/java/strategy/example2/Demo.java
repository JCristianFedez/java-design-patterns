package strategy.example2;

import strategy.example2.context.Context;
import strategy.example2.strategies.StrategyA;
import strategy.example2.strategies.StrategyB;

public class Demo {

  public static void main(String[] args) {
    new Context(new StrategyB()).execute();
    new Context(new StrategyA()).execute();
    new Context().execute();
  }
}

package com.cristian.design.patterns.example2;

import com.cristian.design.patterns.example2.context.Context;
import com.cristian.design.patterns.example2.strategies.StrategyA;
import com.cristian.design.patterns.example2.strategies.StrategyB;

public class Demo {

  public static void main(String[] args) {
    new Context(new StrategyB()).execute();
    new Context(new StrategyA()).execute();
    new Context().execute();
  }
}

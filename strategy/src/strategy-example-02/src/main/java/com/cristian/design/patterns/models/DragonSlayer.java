package com.cristian.design.patterns.models;

import com.cristian.design.patterns.strategies.DragonSlayingStrategy;

public class DragonSlayer {

  private DragonSlayingStrategy strategy;

  public DragonSlayer(final DragonSlayingStrategy strategy) {
    this.strategy = strategy;
  }

  public void changeStrategy(final DragonSlayingStrategy strategy) {
    this.strategy = strategy;
  }

  public void goToBattle() {
    strategy.execute();
  }
}
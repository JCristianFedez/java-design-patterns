package com.cristian.design.patterns.concreteextensions;

import com.cristian.design.patterns.abstractextensions.SoldierExtension;
import com.cristian.design.patterns.units.SoldierUnit;

public record Soldier(SoldierUnit soldierUnit) implements SoldierExtension {

  @Override
  public void soldierReady() {
    System.out.printf("[Soldier] {} is ready!%n", this.soldierUnit.getName());
  }
}

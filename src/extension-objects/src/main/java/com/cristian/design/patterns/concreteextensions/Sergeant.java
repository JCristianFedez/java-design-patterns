package com.cristian.design.patterns.concreteextensions;

import com.cristian.design.patterns.abstractextensions.SergeantExtension;
import com.cristian.design.patterns.units.SergeantUnit;

public record Sergeant(SergeantUnit sergeantUnit) implements SergeantExtension {

  @Override
  public void sergeantReady() {
    System.out.printf("[Sergeant] {} is ready!%n", this.sergeantUnit.getName());
  }
}

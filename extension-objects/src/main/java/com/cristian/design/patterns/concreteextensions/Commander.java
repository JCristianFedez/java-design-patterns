package com.cristian.design.patterns.concreteextensions;

import com.cristian.design.patterns.abstractextensions.CommanderExtension;
import com.cristian.design.patterns.units.CommanderUnit;

public record Commander(CommanderUnit commanderUnit) implements CommanderExtension {

  @Override
  public void commanderReady() {
    System.out.printf("[Commander] {} is ready!%n", this.commanderUnit.getName());
  }
}

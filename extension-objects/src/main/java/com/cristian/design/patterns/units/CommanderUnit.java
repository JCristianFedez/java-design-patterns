package com.cristian.design.patterns.units;

import java.util.Optional;

import com.cristian.design.patterns.abstractextensions.CommanderExtension;
import com.cristian.design.patterns.abstractextensions.UnitExtension;
import com.cristian.design.patterns.concreteextensions.Commander;

public class CommanderUnit extends Unit {

  public CommanderUnit(final String name) {
    super(name);
  }

  @Override
  public UnitExtension getUnitExtension(final String extensionName) {
    if (extensionName.equals(CommanderExtension.class.getSimpleName())) {
      return Optional.ofNullable(this.unitExtension).orElseGet(() -> {
        this.unitExtension = new Commander(this);
        return this.unitExtension;
      });
    }
    return super.getUnitExtension(extensionName);
  }
}

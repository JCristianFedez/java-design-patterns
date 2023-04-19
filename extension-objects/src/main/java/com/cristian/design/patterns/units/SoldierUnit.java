package com.cristian.design.patterns.units;

import java.util.Optional;

import com.cristian.design.patterns.abstractextensions.SoldierExtension;
import com.cristian.design.patterns.abstractextensions.UnitExtension;
import com.cristian.design.patterns.concreteextensions.Soldier;

public class SoldierUnit extends Unit {

  public SoldierUnit(final String name) {
    super(name);
  }

  @Override
  public UnitExtension getUnitExtension(final String extensionName) {
    if (extensionName.equals(SoldierExtension.class.getSimpleName())) {
      return Optional.ofNullable(this.unitExtension).orElseGet(() -> {
        this.unitExtension = new Soldier(this);
        return this.unitExtension;
      });
    }
    return super.getUnitExtension(extensionName);
  }
}

package com.cristian.design.patterns.units;

import java.util.Optional;

import com.cristian.design.patterns.abstractextensions.SergeantExtension;
import com.cristian.design.patterns.abstractextensions.UnitExtension;
import com.cristian.design.patterns.concreteextensions.Sergeant;

public class SergeantUnit extends Unit {

  public SergeantUnit(final String name) {
    super(name);
  }

  @Override
  public UnitExtension getUnitExtension(final String extensionName) {
    if (extensionName.equals(SergeantExtension.class.getSimpleName())) {
      return Optional.ofNullable(this.unitExtension).orElseGet(() -> {
        this.unitExtension = new Sergeant(this);
        return this.unitExtension;
      });
    }
    return super.getUnitExtension(extensionName);
  }
}

package com.cristian.design.patterns.units;

import com.cristian.design.patterns.abstractextensions.UnitExtension;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Unit {

  @Getter(AccessLevel.PROTECTED)
  protected UnitExtension unitExtension = null;

  private String name;

  protected Unit(final String name) {
    this.name = name;
  }

  public UnitExtension getUnitExtension(final String extensionName) {
    return null;
  }
}

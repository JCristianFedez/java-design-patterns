package com.cristian.design.patterns.unit;

import java.util.Arrays;

public abstract class Unit {

  private final Unit[] children;

  protected Unit(final Unit[] children) {
    this.children = children;
  }

  public void accept(final UnitVisitor visitor) {
    Arrays.stream(this.children).forEach(child -> child.accept(visitor));
  }
}

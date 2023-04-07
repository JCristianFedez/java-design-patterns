package com.cristian.design.patterns.sergeant;

import com.cristian.design.patterns.unit.Unit;
import com.cristian.design.patterns.unit.UnitVisitor;

public class Sergeant extends Unit {

  public Sergeant(final Unit... children) {
    super(children);
  }

  @Override
  public void accept(final UnitVisitor visitor) {
    visitor.visit(this);
    super.accept(visitor);
  }

  @Override
  public String toString() {
    return "Sergeant";
  }
}

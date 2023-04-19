package com.cristian.design.patterns.soldier;

import com.cristian.design.patterns.unit.Unit;
import com.cristian.design.patterns.unit.UnitVisitor;

public class Soldier extends Unit {

  public Soldier(final Unit... children) {
    super(children);
  }

  @Override
  public void accept(final UnitVisitor visitor) {
    visitor.visit(this);
    super.accept(visitor);
  }

  @Override
  public String toString() {
    return "Soldier";
  }
}

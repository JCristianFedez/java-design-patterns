package com.cristian.design.patterns.commander;

import com.cristian.design.patterns.unit.Unit;
import com.cristian.design.patterns.unit.UnitVisitor;

public class Commander extends Unit {

  public Commander(final Unit... children) {
    super(children);
  }

  /**
   * Accept a Visitor.
   * @param visitor UnitVisitor to be accepted
   */
  @Override
  public void accept(final UnitVisitor visitor) {
    visitor.visit(this);
    super.accept(visitor);
  }

  @Override
  public String toString() {
    return "commander";
  }
}
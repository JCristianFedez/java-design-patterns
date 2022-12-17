package com.cristian.design.patterns.elements;

import com.cristian.design.patterns.visitors.Visitor;

public class ThirdElement implements Element{

  @Override
  public void accept(final Visitor visitor) {
    visitor.visit(this);
  }

  public String third() {
    return "Third element executed";
  }
}

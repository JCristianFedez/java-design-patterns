package com.cristian.design.patterns.elements;

import com.cristian.design.patterns.visitors.Visitor;

public class SecondElement implements Element {

  @Override
  public void accept(final Visitor visitor) {
    visitor.visit(this);
  }

  public String second() {
    return "Second element executed";
  }
}

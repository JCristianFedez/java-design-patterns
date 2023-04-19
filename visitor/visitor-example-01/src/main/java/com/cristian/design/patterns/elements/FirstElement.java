package com.cristian.design.patterns.elements;

import com.cristian.design.patterns.visitors.Visitor;

public class FirstElement implements Element {

  @Override
  public void accept(final Visitor visitor) {
    visitor.visit(this);
  }

  public String first() {
    return "First element executed";
  }
}

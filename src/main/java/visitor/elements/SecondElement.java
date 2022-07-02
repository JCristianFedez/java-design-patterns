package visitor.elements;

import visitor.visitors.Visitor;

public class SecondElement implements Element {

  @Override
  public void accept(final Visitor visitor) {
    visitor.visit(this);
  }

  public String second() {
    return "Second element executed";
  }
}

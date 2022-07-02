package visitor.elements;

import visitor.visitors.Visitor;

public class ThirdElement implements Element{

  @Override
  public void accept(final Visitor visitor) {
    visitor.visit(this);
  }

  public String third() {
    return "Third element executed";
  }
}

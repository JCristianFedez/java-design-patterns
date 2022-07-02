package visitor.elements;

import visitor.visitors.Visitor;

public interface Element {

  void accept(final Visitor visitor);
}

package visitor.visitors;

import visitor.elements.FirstElement;
import visitor.elements.SecondElement;
import visitor.elements.ThirdElement;

public interface Visitor {

  void visit(final FirstElement element);

  void visit(final SecondElement element);

  void visit(final ThirdElement element);
}

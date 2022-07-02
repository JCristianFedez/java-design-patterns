package visitor.visitors;

import visitor.elements.FirstElement;
import visitor.elements.SecondElement;
import visitor.elements.ThirdElement;

public class SecondVisitor implements Visitor {

  @Override
  public void visit(final FirstElement element) {
    System.out.println("Segundo visitor y primer elemento: " + element.first());
  }

  @Override
  public void visit(final SecondElement element) {
    System.out.println("Segundo visitor y segundo elemento: " + element.second());
  }

  @Override
  public void visit(final ThirdElement element) {
    System.out.println("Segundo visitor y tercer elemento elemento: " + element.third());
  }
}

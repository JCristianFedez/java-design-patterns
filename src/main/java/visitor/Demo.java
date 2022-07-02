package visitor;

import visitor.elements.FirstElement;
import visitor.elements.SecondElement;
import visitor.elements.ThirdElement;
import visitor.visitors.FirstVisitor;
import visitor.visitors.SecondVisitor;

public class Demo {

  public static void main(String[] args) {
    final FirstElement firstElement = new FirstElement();
    final SecondElement secondElement = new SecondElement();
    final ThirdElement thirdElement = new ThirdElement();

    final FirstVisitor firstVisitor = new FirstVisitor();
    firstVisitor.visit(firstElement);
    firstVisitor.visit(secondElement);
    firstVisitor.visit(thirdElement);

    final SecondVisitor secondVisitor = new SecondVisitor();
    secondVisitor.visit(firstElement);
    secondVisitor.visit(secondElement);
    secondVisitor.visit(thirdElement);
  }
}

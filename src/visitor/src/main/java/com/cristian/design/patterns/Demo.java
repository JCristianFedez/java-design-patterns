package com.cristian.design.patterns;

import com.cristian.design.patterns.elements.FirstElement;
import com.cristian.design.patterns.elements.SecondElement;
import com.cristian.design.patterns.elements.ThirdElement;
import com.cristian.design.patterns.visitors.FirstVisitor;
import com.cristian.design.patterns.visitors.SecondVisitor;

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

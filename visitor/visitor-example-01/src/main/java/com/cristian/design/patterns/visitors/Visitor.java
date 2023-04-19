package com.cristian.design.patterns.visitors;

import com.cristian.design.patterns.elements.FirstElement;
import com.cristian.design.patterns.elements.SecondElement;
import com.cristian.design.patterns.elements.ThirdElement;

public interface Visitor {

  void visit(final FirstElement element);

  void visit(final SecondElement element);

  void visit(final ThirdElement element);
}

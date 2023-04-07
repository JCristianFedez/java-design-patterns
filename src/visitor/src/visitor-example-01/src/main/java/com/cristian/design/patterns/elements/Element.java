package com.cristian.design.patterns.elements;

import com.cristian.design.patterns.visitors.Visitor;

public interface Element {

  void accept(final Visitor visitor);
}

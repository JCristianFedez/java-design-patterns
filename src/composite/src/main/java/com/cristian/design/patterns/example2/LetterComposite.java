package com.cristian.design.patterns.example2;

import java.util.ArrayList;
import java.util.List;

abstract class LetterComposite {

  private final List<LetterComposite> children = new ArrayList<>();

  public void add(final LetterComposite letter) {
    this.children.add(letter);
  }

  protected void printThisBefore() {
  }

  protected void printThisAfter() {
  }

  public void print() {
    printThisBefore();
    this.children.forEach(LetterComposite::print);
    printThisAfter();
  }
}

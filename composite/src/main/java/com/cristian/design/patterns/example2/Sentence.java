package com.cristian.design.patterns.example2;

import java.util.List;

final class Sentence extends LetterComposite {

  public Sentence(final List<Word> words) {
    words.forEach(this::add);
  }

  @Override
  protected void printThisAfter() {
    System.out.print(".");
  }
}

package com.cristian.design.patterns.example2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Word extends LetterComposite {

  private Word(final List<Letter> letters) {
    letters.forEach(this::add);
  }

  public static Word of(final Character... characters) {
    final List<Letter> letters = Stream.of(characters).map(Letter::new).collect(Collectors.toList());
    return new Word(letters);
  }

  @Override
  protected void printThisBefore() {
    System.out.print(" ");
  }
}

package com.cristian.design.patterns.example2;

final class Letter extends LetterComposite {

  private final char character;

  public Letter(final char character) {
    this.character = character;
  }

  @Override
  protected void printThisBefore() {
    System.out.print(character);
  }
}
package com.cristian.design.patterns.expresions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NumberExpression implements Expression {

  private final int number;

  public NumberExpression(final String number) {
    this.number = Integer.parseInt(number);
  }

  @Override
  public int interpret() {
    return this.number;
  }

  @Override
  public String toString() {
    return "Number";
  }
}

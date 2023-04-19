package com.cristian.design.patterns.expresions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MinusExpression implements Expression {

  private final Expression leftExpression;

  private final Expression rightExpression;

  @Override
  public int interpret() {
    return this.leftExpression.interpret() - this.rightExpression.interpret();
  }

  @Override
  public String toString() {
    return "-";
  }
}

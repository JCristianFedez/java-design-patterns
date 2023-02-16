package com.cristian.design.patterns;

import java.util.Stack;

import com.cristian.design.patterns.expresions.Expression;
import com.cristian.design.patterns.expresions.MinusExpression;
import com.cristian.design.patterns.expresions.MultiplyExpression;
import com.cristian.design.patterns.expresions.NumberExpression;
import com.cristian.design.patterns.expresions.PlusExpression;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InterpreterDemo {

  public static void main(String[] args) {
    new InterpreterDemo().run();
  }

  private void run() {
    // the halfling kids are learning some basic math at school
    // define the math string we want to parse
    final var tokenString = "4 3 2 - 1 + *";

    // the stack holds the parsed expressions
    final Stack<Expression> stack = new Stack<>();

    // tokenize the string and go through them one by one
    var tokenList = tokenString.split(" ");
    for (var s : tokenList) {
      if (isOperator(s)) {
        // when an operator is encountered we expect that the numbers can be popped from the top of
        // the stack
        final Expression rightExpression = stack.pop();
        final Expression leftExpression = stack.pop();
        LOGGER.info("popped from stack left: {} right: {}",
            leftExpression.interpret(), rightExpression.interpret());
        final Expression operator = getOperatorInstance(s, leftExpression, rightExpression);
        LOGGER.info("operator: {}", operator);
        final int result = operator.interpret();
        // the operation result is pushed on top of the stack
        final Expression resultExpression = new NumberExpression(result);
        stack.push(resultExpression);
        LOGGER.info("push result to stack: {}", resultExpression.interpret());
      } else {
        // numbers are pushed on top of the stack
        final Expression i = new NumberExpression(s);
        stack.push(i);
        LOGGER.info("push to stack: {}", i.interpret());
      }
    }
    // in the end, the final result lies on top of the stack
    LOGGER.info("result: {}", stack.pop().interpret());
  }

  /**
   * Checks whether the input parameter is an operator.
   *
   * @param s input string
   * @return true if the input parameter is an operator
   */
  public static boolean isOperator(String s) {
    return s.equals("+") || s.equals("-") || s.equals("*");
  }

  /**
   * Returns correct expression based on the parameters.
   *
   * @param s input string
   * @param left expression
   * @param right expression
   * @return expression
   */
  public static Expression getOperatorInstance(String s, Expression left, Expression right) {
    return switch (s) {
      case "+" -> new PlusExpression(left, right);
      case "-" -> new MinusExpression(left, right);
      default -> new MultiplyExpression(left, right);
    };
  }
}

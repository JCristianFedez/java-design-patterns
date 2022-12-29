package com.cristian.design.patterns;

class HpPrinter implements Printer {

  @Override
  public void print(final String message) {
    System.out.printf("HP Printer : %s%n", message);
  }
}

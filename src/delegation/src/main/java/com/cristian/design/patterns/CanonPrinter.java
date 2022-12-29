package com.cristian.design.patterns;

class CanonPrinter implements Printer {

  @Override
  public void print(final String message) {
    System.out.printf("Canon Printer : %s%n", message);
  }
}

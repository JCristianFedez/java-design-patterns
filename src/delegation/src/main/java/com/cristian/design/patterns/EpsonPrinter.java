package com.cristian.design.patterns;

class EpsonPrinter implements Printer {

  @Override
  public void print(final String message) {
    System.out.printf("Epson Printer : {}%n", message);
  }
}

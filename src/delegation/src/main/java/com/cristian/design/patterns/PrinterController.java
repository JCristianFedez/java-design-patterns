package com.cristian.design.patterns;

class PrinterController implements Printer {

  private final Printer printer;

  public PrinterController(final Printer printer) {
    this.printer = printer;
  }

  @Override
  public void print(final String message) {
    this.printer.print(message);
  }
}

package com.cristian.design.patterns;

class Demo {

  private static final String MESSAGE_TO_PRINT = "Hello world!";

  public static void main(String[] args) {
    final PrinterController hpController = new PrinterController(new HpPrinter());
    hpController.print(MESSAGE_TO_PRINT);

    final PrinterController canonController = new PrinterController(new CanonPrinter());
    canonController.print(MESSAGE_TO_PRINT);

    final PrinterController epsonController = new PrinterController(new EpsonPrinter());
    epsonController.print(MESSAGE_TO_PRINT);
  }
}

package com.cristian.design.patterns;

import java.io.FileNotFoundException;

public class ModuleDemo {

  private static final String ERROR = "Error";

  private static final String MESSAGE = "Message";

  private FileLoggerModule fileLoggerModule;

  private ConsoleLoggerModule consoleLoggerModule;

  public static void main(String[] args) throws FileNotFoundException {
    new ModuleDemo().run();
  }

  private void run() throws FileNotFoundException {
    prepare();
    execute();
    unprepare();
  }

  private void execute() {
    this.fileLoggerModule.printString(MESSAGE);
    this.fileLoggerModule.printErrorString(ERROR);

    this.consoleLoggerModule.printString(MESSAGE);
    this.consoleLoggerModule.printErrorString(ERROR);
  }

  private void unprepare() {
    this.fileLoggerModule.unprepare();
  }

  private void prepare() throws FileNotFoundException {
    this.fileLoggerModule = FileLoggerModule.getSingleton().prepare();
    this.consoleLoggerModule = ConsoleLoggerModule.getInstance();
  }
}

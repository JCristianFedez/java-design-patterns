package com.cristian.design.patterns;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileLoggerModule {

  private static final String OUTPUT_FILE = "output.txt";

  private static final String ERROR_FILE = "error.txt";

  private static FileLoggerModule singleton = null;

  public PrintStream output = null;

  public PrintStream error = null;

  private FileLoggerModule() {
  }

  public static FileLoggerModule getSingleton() {
    if (FileLoggerModule.singleton == null) {
      FileLoggerModule.singleton = new FileLoggerModule();
    }

    return FileLoggerModule.singleton;
  }

  public FileLoggerModule prepare() throws FileNotFoundException {
    LOGGER.debug("FileLoggerModule::prepare();");
    this.output = new PrintStream(new FileOutputStream(OUTPUT_FILE));
    this.error = new PrintStream(new FileOutputStream(ERROR_FILE));
    return this;
  }

  public void unprepare() {
    clearPrinter(this.output);
    clearPrinter(this.error);

    LOGGER.debug("FileLoggerModule::unprepare();");
  }

  public void printString(final String value) {
    this.output.println(value);
  }

  public void printErrorString(final String value) {
    this.error.println(value);
  }

  private void clearPrinter(final PrintStream error) {
    if (error != null) {

      error.flush();
      error.close();
    }
  }
}

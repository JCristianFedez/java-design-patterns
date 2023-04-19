package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleLoggerModule {

  private static ConsoleLoggerModule instance = null;

  private ConsoleLoggerModule() {
  }

  public static ConsoleLoggerModule getInstance() {
    if (ConsoleLoggerModule.instance == null) {
      ConsoleLoggerModule.instance = new ConsoleLoggerModule();
    }

    return ConsoleLoggerModule.instance;
  }

  public void printString(final String value) {
    LOGGER.debug(value);
  }

  public void printErrorString(final String value) {
    LOGGER.error(value);
  }
}

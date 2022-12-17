package com.cristian.design.patterns;

import com.cristian.design.patterns.logger.Logger;

final class Demo {

  private static final Logger LOGGER = Logger.fromType(Logger.class);

  public static void main(String[] args) {
    final SimpleTask simpleTask = new SimpleTask();
    simpleTask.executeWith(() -> LOGGER.info("I'm done now."));
  }
}

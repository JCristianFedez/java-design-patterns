package com.cristian.design.patterns;

import com.cristian.design.patterns.logger.Logger;

final class SimpleTask implements Task {

  private static final Logger LOGGER = Logger.fromType(SimpleTask.class);

  @Override
  public void execute() {
    LOGGER.info("Perform some important activity and after call the callback method.");
  }
}

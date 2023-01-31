package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
final class SimpleTask implements Task {

  @Override
  public void execute() {
    LOGGER.info("Perform some important activity and after call the callback method.");
  }
}

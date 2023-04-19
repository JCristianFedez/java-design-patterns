package com.cristian.design.patterns.buttons;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WindowsButton implements Button {

  @Override
  public void paint() {
    LOGGER.info("You've created WindowsButton.");
  }
}

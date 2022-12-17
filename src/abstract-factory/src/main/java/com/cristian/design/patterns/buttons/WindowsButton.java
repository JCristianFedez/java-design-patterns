package com.cristian.design.patterns.buttons;

import com.cristian.design.patterns.logger.Logger;

public class WindowsButton implements Button {

  private static final Logger LOGGER = Logger.fromType(Button.class);

  @Override
  public void paint() {
    LOGGER.info("You've created WindowsButton.");
  }
}

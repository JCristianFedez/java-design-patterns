package com.cristian.design.patterns.checkboxes;

import com.cristian.design.patterns.logger.Logger;

public class WindowsCheckbox implements Checkbox {

  private static final Logger LOGGER = Logger.fromType(Checkbox.class);

  @Override
  public void paint() {
    LOGGER.info("You've created WindowsCheckbox");
  }
}

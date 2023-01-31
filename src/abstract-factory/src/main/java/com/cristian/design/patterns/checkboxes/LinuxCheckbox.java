package com.cristian.design.patterns.checkboxes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinuxCheckbox implements Checkbox {

  @Override
  public void paint() {
    LOGGER.info("You've created LinuxCheckbox");
  }
}

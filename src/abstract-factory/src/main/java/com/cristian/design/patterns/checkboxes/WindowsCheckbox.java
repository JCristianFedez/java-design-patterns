package com.cristian.design.patterns.checkboxes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WindowsCheckbox implements Checkbox {

  @Override
  public void paint() {
    log.info("You've created WindowsCheckbox");
  }
}

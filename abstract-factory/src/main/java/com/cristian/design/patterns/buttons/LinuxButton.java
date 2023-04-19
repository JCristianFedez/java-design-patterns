package com.cristian.design.patterns.buttons;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinuxButton implements Button {

  @Override
  public void paint() {
    LOGGER.info("You've created LinuxButton.");
  }
}

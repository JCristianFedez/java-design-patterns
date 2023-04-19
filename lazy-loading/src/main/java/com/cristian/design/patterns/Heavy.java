package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Heavy {

  public Heavy() {
    LOGGER.info("Creating Heavy ...");
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      LOGGER.error("Exception caught", e);
      Thread.currentThread().interrupt();
    }
    LOGGER.info("... Heavy created");
  }
}

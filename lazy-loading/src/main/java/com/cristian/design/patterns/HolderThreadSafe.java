package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HolderThreadSafe {

  private Heavy heavy;

  public HolderThreadSafe() {
    LOGGER.info("HolderThreadSafe created");
  }

  public synchronized Heavy getHeavy() {
    if (this.heavy == null) {
      this.heavy = new Heavy();
    }
    return this.heavy;
  }
}

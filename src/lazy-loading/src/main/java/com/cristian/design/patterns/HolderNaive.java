package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HolderNaive {

  private Heavy heavy;

  public HolderNaive() {
    LOGGER.info("HolderNaive created");
  }

  public Heavy getHeavy() {
    if (this.heavy == null) {
      this.heavy = new Heavy();
    }
    return this.heavy;
  }
}

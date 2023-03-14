package com.cristian.design.patterns;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Stew {

  private int numPotatoes;

  private int numCarrots;

  private int numMeat;

  private int numPeppers;

  public void mix() {
    LOGGER.info("Mixing the stew we find: {} potatoes, {} carrots, {} meat and {} peppers",
        this.numPotatoes, this.numCarrots, this.numMeat, this.numPeppers);
  }

  public void taste() {
    LOGGER.info("Tasting the stew");
    if (this.numPotatoes > 0) {
      this.numPotatoes--;
    }
    if (this.numCarrots > 0) {
      this.numCarrots--;
    }
    if (this.numMeat > 0) {
      this.numMeat--;
    }
    if (this.numPeppers > 0) {
      this.numPeppers--;
    }
  }
}
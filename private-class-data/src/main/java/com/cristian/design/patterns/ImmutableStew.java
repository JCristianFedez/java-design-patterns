package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImmutableStew {

  private final StewData data;

  public ImmutableStew(int numPotatoes, int numCarrots, int numMeat, int numPeppers) {
    this.data = new StewData(numPotatoes, numCarrots, numMeat, numPeppers);
  }

  public void mix() {
    LOGGER.info("Mixing the immutable stew we find: {} potatoes, {} carrots, {} meat and {} peppers",
        this.data.numPotatoes(), this.data.numCarrots(), this.data.numMeat(), this.data.numPeppers());
  }
}

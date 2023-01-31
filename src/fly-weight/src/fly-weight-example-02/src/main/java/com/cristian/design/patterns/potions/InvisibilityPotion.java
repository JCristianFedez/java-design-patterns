package com.cristian.design.patterns.potions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvisibilityPotion implements Potion {

  @Override
  public void drink() {
    LOGGER.info("You become invisible. (Potion={})", System.identityHashCode(this));
  }
}

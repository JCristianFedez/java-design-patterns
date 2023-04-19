package com.cristian.design.patterns.potions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HealingPotion implements Potion {

  @Override
  public void drink() {
    LOGGER.info("You feel healed. (Potion={})", System.identityHashCode(this));
  }
}

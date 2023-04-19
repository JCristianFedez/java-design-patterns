package com.cristian.design.patterns.potions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HolyWaterPotion implements Potion {

  @Override
  public void drink() {
    LOGGER.info("You feel blessed. (Potion={})", System.identityHashCode(this));
  }
}

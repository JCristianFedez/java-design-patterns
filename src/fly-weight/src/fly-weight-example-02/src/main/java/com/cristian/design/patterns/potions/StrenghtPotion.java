package com.cristian.design.patterns.potions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrenghtPotion implements Potion {

  @Override
  public void drink() {
    LOGGER.info("You feel strong. (Potion={})", System.identityHashCode(this));
  }
}

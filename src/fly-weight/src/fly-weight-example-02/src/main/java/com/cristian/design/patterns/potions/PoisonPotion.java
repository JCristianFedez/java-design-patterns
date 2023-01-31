package com.cristian.design.patterns.potions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PoisonPotion implements Potion {

  @Override
  public void drink() {
    LOGGER.info("Urgh! This is poisonous. (Poison={})", System.identityHashCode(this));
  }
}

package com.cristian.design.patterns.superpowers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GroundDive extends Superpower {

  @Override
  public void activate() {
    move(0, 0, -20);
    playSound("GROUND_DIVE_SOUND", 5);
    spawnParticles("GROUND_DIVE_PARTICLE", 20);
  }
}

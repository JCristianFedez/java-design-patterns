package com.cristian.design.patterns.superpowers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SkyLaunch extends Superpower {

  @Override
  public void activate() {
    move(0, 0, 20);
    playSound("SKY_LAUNCH_SOUND", 1);
    spawnParticles("SKY_LAUNCH_PARTICLE", 100);
  }
}

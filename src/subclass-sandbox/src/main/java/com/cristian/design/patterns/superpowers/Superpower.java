package com.cristian.design.patterns.superpowers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Superpower {

  public abstract void activate();

  protected void move(final double x, final double y, final double z) {
    LOGGER.info("Move to ({}, {}, {})", x, y, z);
  }

  protected void playSound(final String soundName, final int volume) {
    LOGGER.info("Play {} with volume {}", soundName, volume);
  }

  protected void spawnParticles(final String particleType, final int count) {
    LOGGER.info("Spawn {} particle with type {}", count, particleType);
  }
}

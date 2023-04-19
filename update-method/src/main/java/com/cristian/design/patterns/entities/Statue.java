package com.cristian.design.patterns.entities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Statue extends Entity {

  private int frames = 0;
  private int delay = 0;

  public Statue(final int id) {
    super(id);
  }

  public Statue(final int id, final int delay) {
    super(id);
    this.delay = delay;
  }

  @Override
  public void update() {
    if (++this.frames == this.delay) {
      shootLightning();
      this.frames = 0;
    }
  }

  private void shootLightning() {
    LOGGER.info("Statue {} shoots lightning!", getId());
  }
}

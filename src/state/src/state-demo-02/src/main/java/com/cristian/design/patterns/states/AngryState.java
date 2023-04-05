package com.cristian.design.patterns.states;

import com.cristian.design.patterns.models.Mammoth;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record AngryState(Mammoth mammoth) implements State {

  @Override
  public void observe() {
    LOGGER.info("{} is furious!", this.mammoth);
  }

  @Override
  public void onEnterState() {
    LOGGER.info("{} gets angry!", this.mammoth);
  }
}

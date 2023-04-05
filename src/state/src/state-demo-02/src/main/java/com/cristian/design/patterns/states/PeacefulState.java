package com.cristian.design.patterns.states;

import com.cristian.design.patterns.models.Mammoth;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record PeacefulState(Mammoth mammoth) implements State {

  @Override
  public void observe() {
    LOGGER.info("{} is calm and peaceful.", this.mammoth);
  }

  @Override
  public void onEnterState() {
    LOGGER.info("{} calms down.", this.mammoth);
  }
}

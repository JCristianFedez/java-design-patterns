package com.cristian.design.patterns.strategies;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MeleeStrategy implements DragonSlayingStrategy {

  @Override
  public void execute() {
    LOGGER.info("With your Excalibur you sever the dragon's head!");
  }
}

package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Guard(int id) implements Permission, Entity {

  public void openTheDoor() {
    LOGGER.info("You enter");
  }

  @Override
  public int getId() {
    return id();
  }
}

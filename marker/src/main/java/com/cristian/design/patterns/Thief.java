package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Thief(int id) implements Entity {

  @Override
  public int getId() {
    return id();
  }
}

package com.cristian.design.patterns;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StarType {
  SUN("sun"),
  RED_GIANT("red giant"),
  WHITE_DWARF("white dwarf"),
  SUPERNOVA("supernova"),
  DEAD("dead star");

  private final String title;

  @Override
  public String toString() {
    return this.title;
  }
}

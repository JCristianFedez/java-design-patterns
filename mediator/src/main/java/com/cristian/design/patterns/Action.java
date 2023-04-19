package com.cristian.design.patterns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Action {
  HUNT("hunted a rabbit", "arrives for dinner"),
  TALE("tells a tale", "comes to listen"),
  GOLD("found gold", "takes his share of the gold"),
  ENEMY("spotted enemies", "runs for cover"),
  NONE("", "");

  private final String title;

  @Getter
  private final String description;

  @Override
  public String toString() {
    return this.title;
  }
}

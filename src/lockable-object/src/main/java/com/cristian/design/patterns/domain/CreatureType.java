package com.cristian.design.patterns.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CreatureType {
  ORC(70, 50),
  HUMAN(60, 60),
  ELF(90, 40);

  private final int baseHealth;

  private final int baseDamage;
}

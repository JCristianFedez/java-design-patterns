package com.cristian.design.patterns.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GiantModel {

  private Health health;

  private Fatigue fatigue;

  private Nourishment nourishment;

  @Override
  public String toString() {
    return String.format("The giant looks %s, %s and %s.", this.health, this.fatigue, this.nourishment);
  }
}

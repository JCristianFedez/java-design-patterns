package com.cristian.design.patterns.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class GiantModel {

  private final String name;

  private Health health;

  private Fatigue fatigue;

  private Nourishment nourishment;
}

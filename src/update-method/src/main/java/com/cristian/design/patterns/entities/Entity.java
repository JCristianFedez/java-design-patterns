package com.cristian.design.patterns.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Entity {

  private final int id;

  @Setter
  private int position = 0;

  protected Entity(final int id) {
    this.id = id;
  }

  public abstract void update();
}

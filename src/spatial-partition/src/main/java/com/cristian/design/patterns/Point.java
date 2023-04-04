package com.cristian.design.patterns;

import java.util.Collection;
import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public abstract class Point<T> {

  private final int id;

  private int coordinateX;

  private int coordinateY;

  protected abstract void move();

  /**
   * Defines conditions for interacting with an object.
   */
  protected abstract boolean touches(T obj);

  /**
   * Handling interactions/collisions with other objects.
   */
  protected abstract void handleCollision(Collection<? extends Point<T>> toCheck, Map<Integer, T> all);

  protected void increaseCoordinateX(final int quantityToIncrease) {
    this.coordinateX += quantityToIncrease;
  }

  protected void increaseCoordinateY(final int quantityToIncrease) {
    this.coordinateY += quantityToIncrease;
  }
}

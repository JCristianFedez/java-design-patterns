package com.cristian.design.patterns;

import java.util.Map;

import lombok.Getter;

@Getter
public abstract class SpatialPartitionGeneric<T> {

  private final Map<Integer, T> playerPositions;

  private final QuadTree<T> quadTree;

  protected SpatialPartitionGeneric(final Map<Integer, T> playerPositions, final QuadTree<T> quadTree) {
    this.playerPositions = playerPositions;
    this.quadTree = quadTree;
  }

  public abstract void handleCollisionsUsingQt(T obj);

}

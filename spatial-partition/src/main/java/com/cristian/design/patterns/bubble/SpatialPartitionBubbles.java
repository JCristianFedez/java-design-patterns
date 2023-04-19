package com.cristian.design.patterns.bubble;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cristian.design.patterns.Point;
import com.cristian.design.patterns.QuadTree;
import com.cristian.design.patterns.Rect;
import com.cristian.design.patterns.SpatialPartitionGeneric;

public class SpatialPartitionBubbles extends SpatialPartitionGeneric<Bubble> {

  public SpatialPartitionBubbles(final Map<Integer, Bubble> playerPositions, final QuadTree<Bubble> quadTree) {
    super(playerPositions, quadTree);
  }

  @Override
  public void handleCollisionsUsingQt(final Bubble bubble) {
    final Rect rect = new Rect(bubble.getCoordinateX(), bubble.getCoordinateY(), 2D * bubble.getRadius(), 2D * bubble.getRadius());
    final List<Point<Bubble>> quadTreeQueryResult = new ArrayList<>();
    getQuadTree().query(rect, quadTreeQueryResult);
    bubble.handleCollision(quadTreeQueryResult, getPlayerPositions());
  }
}

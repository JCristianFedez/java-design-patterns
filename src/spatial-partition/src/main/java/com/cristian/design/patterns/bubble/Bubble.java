package com.cristian.design.patterns.bubble;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.Map;

import com.cristian.design.patterns.Point;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bubble extends Point<Bubble> {

  private static final SecureRandom RANDOM = new SecureRandom();

  @Getter
  private final int radius;

  public Bubble(final int id, final int coordinateX, final int coordinateY, final int radius) {
    super(id, coordinateX, coordinateY);
    this.radius = radius;
  }

  @Override
  public void move() {
    // Moves by 1 unit in either direction.
    increaseCoordinateX(RANDOM.nextInt(3) - 1);
    increaseCoordinateY(RANDOM.nextInt(3) - 1);
  }

  @Override
  protected boolean touches(final Bubble other) {
    return (getCoordinateX() - other.getCoordinateX()) * (getCoordinateX() - other.getCoordinateX())
        + (getCoordinateY() - other.getCoordinateY()) * (getCoordinateY() - other.getCoordinateY())
        <= (this.radius + other.radius) * (this.radius + other.radius);
  }

  @Override
  public void handleCollision(final Collection<? extends Point<Bubble>> toCheck, final Map<Integer, Bubble> all) {
    boolean toBePopped = false;
    for (final Point<Bubble> point : toCheck) {
      final int otherId = point.getId();
      if (all.get(otherId) != null //the bubble hasn't been popped yet
          && getId() != otherId  //the two bubbles are not the same
          && touches(all.get(otherId))) { //the bubbles touch
        all.get(otherId).pop(all);
        toBePopped = true;
      }
    }

    if (toBePopped) {
      this.pop(all);
    }
  }

  public void pop(final Map<Integer, Bubble> allBubbles) {
    LOGGER.info("Bubble {} popped at (X:{}, Y:{})!", getId(), getCoordinateX(), getCoordinateY());
    allBubbles.remove(getId());
  }
}

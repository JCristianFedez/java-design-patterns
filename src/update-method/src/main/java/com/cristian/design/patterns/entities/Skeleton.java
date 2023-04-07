package com.cristian.design.patterns.entities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Skeleton extends Entity {

  private static final int PATROLLING_LEFT_BOUNDING = 0;

  private static final int PATROLLING_RIGHT_BOUNDING = 100;

  private boolean patrollingLeft;

  public Skeleton(final int id) {
    super(id);
  }

  public Skeleton(final int id, final int position) {
    super(id);
    setPosition(position);
  }

  @Override
  public void update() {
    if (this.patrollingLeft) {
      setPosition(getPosition() - 1);
      if (getPosition() == PATROLLING_LEFT_BOUNDING) {
        this.patrollingLeft = false;
      }
    } else {
      setPosition(getPosition() + 1);
      if (getPosition() == PATROLLING_RIGHT_BOUNDING) {
        this.patrollingLeft = true;
      }
    }
    LOGGER.info("Skeleton {} is on position {}.", getId(), getPosition());
  }

}

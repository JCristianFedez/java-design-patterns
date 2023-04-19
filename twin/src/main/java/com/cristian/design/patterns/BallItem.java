package com.cristian.design.patterns;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BallItem extends GameItem {

  private boolean isSuspended;

  @Setter
  private BallThread twin;

  @Override
  public void doDraw() {
    LOGGER.info("doDraw");
  }

  public void move() {
    LOGGER.info("move");
  }

  @Override
  public void click() {
    this.isSuspended = !this.isSuspended;
    if (this.isSuspended) {
      this.twin.suspendMe();
    } else {
      this.twin.resumeMe();
    }
  }
}

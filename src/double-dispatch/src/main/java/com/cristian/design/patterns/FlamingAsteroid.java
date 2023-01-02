package com.cristian.design.patterns;

class FlamingAsteroid extends Meteoroid {

  public FlamingAsteroid(final int left, final int top, final int right, final int bottom) {
    super(left, top, right, bottom);
  }

  @Override
  public void collision(final GameObject gameObject) {
    gameObject.collisionResolve(this);
  }
}

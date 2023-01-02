package com.cristian.design.patterns;

class SpaceStationIss extends SpaceStationMir {

  public SpaceStationIss(final int left, final int top, final int right, final int bottom) {
    super(left, top, right, bottom);
  }

  @Override
  public void collision(final GameObject gameObject) {
    gameObject.collisionResolve(this);
  }
}

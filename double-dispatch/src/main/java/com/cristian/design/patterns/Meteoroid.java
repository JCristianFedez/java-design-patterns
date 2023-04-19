package com.cristian.design.patterns;

class Meteoroid extends GameObject {

  public Meteoroid(final int left, final int top, final int right, final int bottom) {
    super(left, top, right, bottom);
  }

  @Override
  public void collision(final GameObject gameObject) {
    gameObject.collisionResolve(this);
  }

  @Override
  public void collisionResolve(final FlamingAsteroid asteroid) {
    printCollision(asteroid.getClass().getSimpleName());
  }

  @Override
  public void collisionResolve(final Meteoroid meteoroid) {
    printCollision(meteoroid.getClass().getSimpleName());
  }

  @Override
  public void collisionResolve(final SpaceStationMir mir) {
    printCollision(mir.getClass().getSimpleName());
  }

  @Override
  public void collisionResolve(final SpaceStationIss iss) {
    printCollision(iss.getClass().getSimpleName());
  }

  private void printCollision(final String iss) {
    System.out.printf(AppConstants.HITS.concat("%n"), iss, getClass().getSimpleName());
  }
}

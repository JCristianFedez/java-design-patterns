package com.cristian.design.patterns;

class SpaceStationMir extends GameObject {

  public static final String COLLISION_FORMAT = AppConstants.HITS.concat(" {} is damaged!");

  public SpaceStationMir(final int left, final int top, final int right, final int bottom) {
    super(left, top, right, bottom);
  }

  @Override
  public void collision(final GameObject gameObject) {
    gameObject.collisionResolve(this);
  }

  @Override
  public void collisionResolve(final FlamingAsteroid asteroid) {
    final String strToFormat = COLLISION_FORMAT.concat(" {} is set on fire!%n");
    final String className = getClass().getSimpleName();
    System.out.printf(strToFormat, asteroid.getClass().getSimpleName(), className, className, className);
    setDamaged(true);
    setOnFire(true);
  }

  @Override
  public void collisionResolve(final Meteoroid meteoroid) {
    collisionPrint(meteoroid.getClass().getSimpleName());
  }

  @Override
  public void collisionResolve(final SpaceStationMir mir) {
    collisionPrint(mir.getClass().getSimpleName());
  }

  @Override
  public void collisionResolve(final SpaceStationIss iss) {
    collisionPrint(iss.getClass().getSimpleName());
  }

  private void collisionPrint(final String gameObjectName) {
    final String className = getClass().getSimpleName();
    System.out.printf(COLLISION_FORMAT.concat("%n"), gameObjectName, className, className);
    setDamaged(true);
  }
}

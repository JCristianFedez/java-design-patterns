package com.cristian.design.patterns;

public class GameController {

  protected final Bullet bullet = new Bullet();

  public void moveBullet(final float offset) {
    final float currentPosition = this.bullet.getPosition();
    this.bullet.setPosition(currentPosition + offset);
  }

  public float getBulletPosition() {
    return this.bullet.getPosition();
  }
}

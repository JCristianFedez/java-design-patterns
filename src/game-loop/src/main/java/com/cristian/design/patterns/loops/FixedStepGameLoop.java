package com.cristian.design.patterns.loops;

public class FixedStepGameLoop extends GameLoop {

  private static final long MS_PER_FRAME = 20;

  @Override
  protected void processGameLoop() {
    long previousTime = System.currentTimeMillis();
    long lag = 0L;
    while (isGameRunning()) {
      final long currentTime = System.currentTimeMillis();
      final long elapsedTime = currentTime - previousTime;
      previousTime = currentTime;
      lag += elapsedTime;

      processInput();

      while (lag >= MS_PER_FRAME) {
        update();
        lag -= MS_PER_FRAME;
      }

      render();
    }
  }

  private void update() {
    this.controller.moveBullet(0.5f * MS_PER_FRAME / 1000);
  }
}

package com.cristian.design.patterns.loops;

public class VariableStepGameLoop extends GameLoop {

  @Override
  protected void processGameLoop() {
    long lastFrameTime = System.currentTimeMillis();
    while (isGameRunning()) {
      processInput();
      final long currentFrameTime = System.currentTimeMillis();
      final long elapsedTime = currentFrameTime - lastFrameTime;
      update(elapsedTime);
      lastFrameTime = currentFrameTime;
      render();
    }
  }

  private void update(final long elapsedTime) {
    this.controller.moveBullet(0.5f * elapsedTime / 1000);
  }
}

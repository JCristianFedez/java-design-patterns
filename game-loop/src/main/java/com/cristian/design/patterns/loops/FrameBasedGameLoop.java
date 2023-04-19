package com.cristian.design.patterns.loops;

public class FrameBasedGameLoop extends GameLoop {

  @Override
  protected void processGameLoop() {
    while (isGameRunning()) {
      processInput();
      update();
      render();
    }
  }

  private void update() {
    this.controller.moveBullet(0.5f);
  }
}

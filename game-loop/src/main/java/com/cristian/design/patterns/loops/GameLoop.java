package com.cristian.design.patterns.loops;

import java.security.SecureRandom;

import com.cristian.design.patterns.GameController;
import com.cristian.design.patterns.GameStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class GameLoop {

  protected final GameController controller = new GameController();

  protected volatile GameStatus status = GameStatus.STOPPED;

  public void run() {
    this.status = GameStatus.RUNNING;
    new Thread(this::processGameLoop).start();
  }

  public void stop() {
    this.status = GameStatus.STOPPED;
  }

  public boolean isGameRunning() {
    return GameStatus.RUNNING.equals(this.status);
  }

  /**
   * Handle any user input that has happened since the last call. In order to simulate the situation in real-life game, here we add a random
   * time lag. The time lag ranges from 50 ms to 250 ms.
   */
  protected void processInput() {
    final int lag = new SecureRandom().nextInt(200) + 50;
    try {
      Thread.sleep(lag);
    } catch (InterruptedException e) {
      LOGGER.error(e.getMessage());
      Thread.currentThread().interrupt();
    }
  }

  protected void render() {
    final float position = this.controller.getBulletPosition();
    LOGGER.info("Current bullet position: {}", position);
  }

  protected abstract void processGameLoop();

}

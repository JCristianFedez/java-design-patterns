package com.cristian.design.patterns;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import com.cristian.design.patterns.entities.Entity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class World {

  private final List<Entity> entities = new ArrayList<>();

  private volatile boolean isRunning;

  /**
   * Main game loop. This loop will always run until the game is over. For each loop it will process user input, update internal status, and
   * render the next frames. For more detail please refer to the game-loop pattern.
   */
  private void gameLoop() {
    while (this.isRunning) {
      processInput();
      update();
      render();
    }
  }

  /**
   * Handle any user input that has happened since the last call. In order to simulate the situation in real-life game, here we add a random
   * time lag. The time lag ranges from 50 ms to 250 ms.
   */
  private void processInput() {
    final int lag = new SecureRandom().nextInt(200) + 50;
    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(lag));
  }

  /**
   * Update internal status. The update method pattern invoke udpate method for each entity in the game.
   */
  private void update() {
    this.entities.forEach(Entity::update);
  }

  /**
   * Render the next frame. Here we do nothing since it is not related to the pattern.
   */
  private void render() {
    // Does Nothing
  }

  /**
   * Run game loop.
   */
  public void run() {
    LOGGER.info("Start game.");
    this.isRunning = true;
    new Thread(this::gameLoop).start();
  }

  /**
   * Stop game loop.
   */
  public void stop() {
    LOGGER.info("Stop game.");
    this.isRunning = false;
  }

  public void addEntity(Entity entity) {
    this.entities.add(entity);
  }
}

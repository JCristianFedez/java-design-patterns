package com.cristian.design.patterns.game;

import com.cristian.design.patterns.game.component.manager.AiComponentManager;
import com.cristian.design.patterns.game.component.manager.PhysicsComponentManager;
import com.cristian.design.patterns.game.component.manager.RenderComponentManager;

public class GameEntity {

  private final AiComponentManager aiComponentManager;

  private final PhysicsComponentManager physicsComponentManager;

  private final RenderComponentManager renderComponentManager;

  public GameEntity(final int numEntities) {
    System.out.printf("Init Game With #Entity : %s%n", numEntities);
    this.aiComponentManager = new AiComponentManager(numEntities);
    this.physicsComponentManager = new PhysicsComponentManager(numEntities);
    this.renderComponentManager = new RenderComponentManager(numEntities);
  }

  public void start() {
    System.out.println("Start game");
    this.aiComponentManager.start();
    this.physicsComponentManager.start();
    this.renderComponentManager.start();
  }

  public void update() {
    System.out.println("Update Game Component");
    this.aiComponentManager.update();
    this.physicsComponentManager.update();
    this.renderComponentManager.render();
  }
}

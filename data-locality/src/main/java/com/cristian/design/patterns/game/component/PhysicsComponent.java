package com.cristian.design.patterns.game.component;

public class PhysicsComponent implements Updateable {

  @Override
  public void update() {
    System.out.println("Updateable physics component of game");
  }
}

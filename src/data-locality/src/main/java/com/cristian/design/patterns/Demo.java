package com.cristian.design.patterns;

import com.cristian.design.patterns.game.GameEntity;

public class Demo {

  public static void main(String[] args) {
    System.out.println("Start Game Application using Data-Locality pattern");
    GameEntity gameEntity = new GameEntity(5);
    gameEntity.start();
    gameEntity.update();
  }

}

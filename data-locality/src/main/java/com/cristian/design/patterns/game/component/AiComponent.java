package com.cristian.design.patterns.game.component;

public class AiComponent implements Updateable {

  @Override
  public void update() {
    System.out.println("Updateable AI component");
  }

}

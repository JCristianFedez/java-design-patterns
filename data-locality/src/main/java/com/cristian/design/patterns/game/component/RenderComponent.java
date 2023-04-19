package com.cristian.design.patterns.game.component;

public class RenderComponent implements Rendeable {

  @Override
  public void render() {
    System.out.println("Render Component");
  }
}

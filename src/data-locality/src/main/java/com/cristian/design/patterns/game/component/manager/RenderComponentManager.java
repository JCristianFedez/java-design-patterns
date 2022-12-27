package com.cristian.design.patterns.game.component.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.cristian.design.patterns.game.component.Rendeable;
import com.cristian.design.patterns.game.component.RenderComponent;

public class RenderComponentManager {

  private final int numEntities;

  private final List<RenderComponent> renderComponents = new ArrayList<>();

  public RenderComponentManager(final int numEntities) {
    this.numEntities = numEntities;
  }

  public void start() {
    System.out.println("Start Render Game Component");
    IntStream.range(0, this.numEntities).boxed()
        .map(ignore -> new RenderComponent())
        .forEach(this.renderComponents::add);
  }

  public void render() {
    System.out.println("Update Render Game Component");
    IntStream.range(0, this.numEntities)
        .boxed()
        .filter(i -> this.renderComponents.size() > i)
        .map(this.renderComponents::get)
        .forEach(Rendeable::render);
  }
}

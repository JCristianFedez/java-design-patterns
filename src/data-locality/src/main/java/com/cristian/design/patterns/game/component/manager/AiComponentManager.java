package com.cristian.design.patterns.game.component.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.cristian.design.patterns.game.component.AiComponent;
import com.cristian.design.patterns.game.component.Updateable;

public class AiComponentManager {

  private final int numEntities;

  private final List<Updateable> aiComponents = new ArrayList<>();

  public AiComponentManager(final int numEntities) {
    this.numEntities = numEntities;
  }

  public void start() {
    System.out.println("Start AI Game Component");
    IntStream.range(0, this.numEntities).boxed()
        .map(ignore -> new AiComponent())
        .forEach(this.aiComponents::add);
  }

  public void update() {
    System.out.println("Update AI Game Component");
    IntStream.range(0, this.numEntities)
        .boxed()
        .filter(i -> this.aiComponents.size() > i)
        .map(this.aiComponents::get)
        .forEach(Updateable::update);
  }
}

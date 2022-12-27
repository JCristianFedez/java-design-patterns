package com.cristian.design.patterns.game.component.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.cristian.design.patterns.game.component.PhysicsComponent;
import com.cristian.design.patterns.game.component.Updateable;

public class PhysicsComponentManager {

  private final int numEntities;

  private final List<PhysicsComponent> physicsComponents = new ArrayList<>();

  public PhysicsComponentManager(final int numEntities) {
    this.numEntities = numEntities;
  }

  public void start() {
    System.out.println("Start Physics Game Component");
    IntStream.range(0, this.numEntities).boxed()
        .map(ignore -> new PhysicsComponent())
        .forEach(this.physicsComponents::add);
  }

  public void update() {
    System.out.println("Update Physics Game Component");
    IntStream.range(0, this.numEntities)
        .boxed()
        .filter(i -> this.physicsComponents.size() > i)
        .map(this.physicsComponents::get)
        .forEach(Updateable::update);
  }

}

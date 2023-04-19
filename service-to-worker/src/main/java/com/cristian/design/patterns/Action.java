package com.cristian.design.patterns;

import com.cristian.design.patterns.models.Fatigue;
import com.cristian.design.patterns.models.GiantModel;
import com.cristian.design.patterns.models.Health;
import com.cristian.design.patterns.models.Nourishment;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Action {

  private final GiantModel model;

  public void updateModel(final Command command) {
    setFatigue(command.fatigue());
    setHealth(command.health());
    setNourishment(command.nourishment());
  }

  public void setHealth(final Health health) {
    this.model.setHealth(health);
  }

  public void setFatigue(final Fatigue fatigue) {
    this.model.setFatigue(fatigue);
  }

  public void setNourishment(final Nourishment nourishment) {
    this.model.setNourishment(nourishment);
  }
}

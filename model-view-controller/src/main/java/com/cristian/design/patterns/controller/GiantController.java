package com.cristian.design.patterns.controller;

import com.cristian.design.patterns.model.Fatigue;
import com.cristian.design.patterns.model.GiantModel;
import com.cristian.design.patterns.model.Health;
import com.cristian.design.patterns.model.Nourishment;
import com.cristian.design.patterns.view.GiantView;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GiantController {

  private final GiantModel model;

  private final GiantView view;

  public void setHealth(final Health health) {
    this.model.setHealth(health);
  }

  public void setFatigue(final Fatigue fatigue) {
    this.model.setFatigue(fatigue);
  }

  public void setNourishment(final Nourishment nourishment) {
    this.model.setNourishment(nourishment);
  }

  public void updateView() {
    this.view.displayGiant(this.model);
  }
}

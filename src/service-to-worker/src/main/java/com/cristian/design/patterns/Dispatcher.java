package com.cristian.design.patterns;

import java.util.ArrayList;
import java.util.List;

import com.cristian.design.patterns.models.GiantModel;
import com.cristian.design.patterns.views.GiantView;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Dispatcher {

  private final GiantView view;

  private final List<Action> actions = new ArrayList<>();

  public void addAction(final Action newAction) {
    this.actions.add(newAction);
  }

  public void performAction(final Command command, final int actionIndex) {
    this.actions.get(actionIndex).updateModel(command);
  }

  public void updateView(final GiantModel model) {
    this.view.displayGiant(model);
  }
}

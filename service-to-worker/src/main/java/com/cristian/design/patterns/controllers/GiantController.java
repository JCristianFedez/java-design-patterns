package com.cristian.design.patterns.controllers;

import com.cristian.design.patterns.Command;
import com.cristian.design.patterns.Dispatcher;
import com.cristian.design.patterns.models.GiantModel;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GiantController {
  private final Dispatcher dispatcher;

  public void setCommand(final Command command, final int index) {
    this.dispatcher.performAction(command, index);
  }

  public void updateView(final GiantModel model) {
    this.dispatcher.updateView(model);
  }
}

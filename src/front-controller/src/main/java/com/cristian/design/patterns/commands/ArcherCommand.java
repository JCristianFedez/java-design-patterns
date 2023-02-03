package com.cristian.design.patterns.commands;

import com.cristian.design.patterns.views.ArcherView;

public class ArcherCommand implements Command {

  @Override
  public void process() {
    new ArcherView().display();
  }
}

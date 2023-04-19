package com.cristian.design.patterns.commands;

import com.cristian.design.patterns.views.CatapultView;

public class CatapultCommand implements Command {

  @Override
  public void process() {
    new CatapultView().display();
  }
}

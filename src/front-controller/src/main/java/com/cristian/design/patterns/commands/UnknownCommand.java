package com.cristian.design.patterns.commands;

import com.cristian.design.patterns.views.ErrorView;

public class UnknownCommand implements Command {

  @Override
  public void process() {
    new ErrorView().display();
  }
}

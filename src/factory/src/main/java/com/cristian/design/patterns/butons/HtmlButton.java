package com.cristian.design.patterns.butons;

import com.cristian.design.patterns.logger.Logger;

public class HtmlButton implements Button {

  private static final Logger LOGGER = Logger.fromType(HtmlButton.class);

  @Override
  public void render() {
    LOGGER.debug("<button>Test Button</button>");
    this.onClick();
  }

  @Override
  public void onClick() {
    LOGGER.debug("Click! Button says - 'Hello World!'");
  }
}

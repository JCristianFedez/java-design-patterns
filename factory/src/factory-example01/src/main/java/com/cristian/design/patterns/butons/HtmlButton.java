package com.cristian.design.patterns.butons;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HtmlButton implements Button {

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

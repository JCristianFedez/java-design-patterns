package com.cristian.design.patterns.stealing.methods;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubtleMethod extends StealingMethod {

  @Override
  protected String pickTarget() {
    return "Shop keeper";
  }

  @Override
  protected void confuseTarget(final String target) {
    LOGGER.info("Approach the {} with tears running and hug him", target);
  }

  @Override
  protected void stealTheItem(final String target) {
    LOGGER.info("While in close contact grab the {}'s wallet.", target);
  }
}

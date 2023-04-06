package com.cristian.design.patterns.stealing.methods;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HitAndRunMethod extends StealingMethod {

  @Override
  protected String pickTarget() {
    return "Old goblin woman";
  }

  @Override
  protected void confuseTarget(final String target) {
    LOGGER.info("Approach the {} from behind.", target);
  }

  @Override
  protected void stealTheItem(final String target) {
    LOGGER.info("Grab the {} handbag and run away fast!", target);
  }
}

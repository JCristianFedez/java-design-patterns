package com.cristian.design.patterns.stealing.methods;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class StealingMethod {

  protected abstract String pickTarget();

  protected abstract void confuseTarget(String target);

  protected abstract void stealTheItem(String target);

  public final void steal() {
    final String target = pickTarget();
    LOGGER.info("The target has been chosen as {}", target);
    confuseTarget(target);
    stealTheItem(target);
  }
}

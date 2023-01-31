package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
final class Hayes implements Modem {

  @Override
  public void accept(final ModemVisitor visitor) {
    if (visitor instanceof HayesVisitor) {
      ((HayesVisitor) visitor).visit(this);
    } else {
      LOGGER.info("Only HayesVisitor is allowed to visit Hayes modem");
    }
  }
}

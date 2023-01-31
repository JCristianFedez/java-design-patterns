package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
final class Zoom implements Modem {

  @Override
  public void accept(final ModemVisitor visitor) {
    if (visitor instanceof ZoomVisitor) {
      ((ZoomVisitor) visitor).visit(this);
    } else {
      LOGGER.info("Only ZoomVisitor is allowed to visit Zoom modem");
    }
  }
}

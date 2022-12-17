package com.cristian.design.patterns;

import com.cristian.design.patterns.logger.Logger;

final class Zoom implements Modem {

  private static final Logger LOGGER = Logger.fromType(Zoom.class);

  @Override
  public void accept(final ModemVisitor visitor) {
    if (visitor instanceof ZoomVisitor) {
      ((ZoomVisitor) visitor).visit(this);
    } else {
      LOGGER.info("Only ZoomVisitor is allowed to visit Zoom modem");
    }
  }
}

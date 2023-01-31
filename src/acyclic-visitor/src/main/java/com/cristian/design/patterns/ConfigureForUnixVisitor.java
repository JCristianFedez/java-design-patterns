package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigureForUnixVisitor implements ZoomVisitor {

  @Override
  public void visit(final Zoom zoom) {
    LOGGER.info("{} used with Unix configuration.", zoom);
  }
}

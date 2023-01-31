package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigureForDOSVisitor implements AllModemVisitor {

  private static void logVisitor(final Modem zoom) {
    log.info("{} used with DOS configurator", zoom);
  }

  @Override
  public void visit(final Hayes hayes) {
    logVisitor(hayes);
  }

  @Override
  public void visit(final Zoom zoom) {
    logVisitor(zoom);
  }
}

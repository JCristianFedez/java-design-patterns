package acyclicvisitor;

import commons.logger.Logger;

public class ConfigureForDOSVisitor implements AllModemVisitor {

  private static final Logger LOGGER = Logger.fromType(ConfigureForDOSVisitor.class);

  private static void loggerVisitor(final Modem zoom) {
    LOGGER.info("%s used with DOS configurator", zoom);
  }

  @Override
  public void visit(final Hayes hayes) {
    loggerVisitor(hayes);
  }

  @Override
  public void visit(final Zoom zoom) {
    loggerVisitor(zoom);
  }
}

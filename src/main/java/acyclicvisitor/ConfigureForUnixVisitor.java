package acyclicvisitor;

import commons.logger.Logger;

public class ConfigureForUnixVisitor implements ZoomVisitor {

  private static final Logger LOGGER = Logger.fromType(ConfigureForUnixVisitor.class);

  @Override
  public void visit(final Zoom zoom) {
    LOGGER.info("%s used with Unix configuration.", zoom);
  }
}

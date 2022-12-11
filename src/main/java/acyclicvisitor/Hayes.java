package acyclicvisitor;

import commons.logger.Logger;

final class Hayes implements Modem {

  private static final Logger LOGGER = Logger.fromType(Hayes.class);

  @Override
  public void accept(final ModemVisitor visitor) {
    if (visitor instanceof HayesVisitor) {
      ((HayesVisitor) visitor).visit(this);
    } else {
      LOGGER.info("Only HayesVisitor is allowed to visit Hayes modem");
    }
  }
}

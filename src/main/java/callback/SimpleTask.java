package callback;

import commons.logger.Logger;

final class SimpleTask extends Task {

  private static final Logger LOGGER = Logger.fromType(SimpleTask.class);

  @Override
  public void execute() {
    LOGGER.info("Perform some important activity and after call the callback method.");
  }
}

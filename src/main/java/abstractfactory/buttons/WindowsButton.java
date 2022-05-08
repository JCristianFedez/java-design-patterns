package abstractfactory.buttons;

import commons.logger.Logger;

public class WindowsButton implements Button {

  private static final Logger LOGGER = Logger.fromType(Button.class);

  @Override
  public void paint() {
    LOGGER.info("You've created WindowsButton.");
  }
}

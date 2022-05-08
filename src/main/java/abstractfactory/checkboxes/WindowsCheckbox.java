package abstractfactory.checkboxes;

import commons.logger.Logger;

public class WindowsCheckbox implements Checkbox {

  private static final Logger LOGGER = Logger.fromType(Checkbox.class);

  @Override
  public void paint() {
    LOGGER.info("You've created WindowsCheckbox");
  }
}

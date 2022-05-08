package abstractfactory.factories;

import abstractfactory.buttons.Button;
import abstractfactory.buttons.WindowsButton;
import abstractfactory.checkboxes.Checkbox;
import abstractfactory.checkboxes.WindowsCheckbox;

public class WindowsFactoryImpl implements Factory {

  @Override
  public Button createButton() {
    return new WindowsButton();
  }

  @Override
  public Checkbox createCheckbox() {
    return new WindowsCheckbox();
  }
}

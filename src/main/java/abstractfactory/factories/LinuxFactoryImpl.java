package abstractfactory.factories;

import abstractfactory.buttons.Button;
import abstractfactory.buttons.LinuxButton;
import abstractfactory.checkboxes.Checkbox;
import abstractfactory.checkboxes.LinuxCheckbox;

public class LinuxFactoryImpl implements Factory {

  @Override
  public Button createButton() {
    return new LinuxButton();
  }

  @Override
  public Checkbox createCheckbox() {
    return new LinuxCheckbox();
  }
}

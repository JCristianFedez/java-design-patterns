package com.cristian.design.patterns.factories;

import com.cristian.design.patterns.buttons.Button;
import com.cristian.design.patterns.buttons.WindowsButton;
import com.cristian.design.patterns.checkboxes.Checkbox;
import com.cristian.design.patterns.checkboxes.WindowsCheckbox;

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

package com.cristian.design.patterns.factories;

import com.cristian.design.patterns.buttons.Button;
import com.cristian.design.patterns.buttons.LinuxButton;
import com.cristian.design.patterns.checkboxes.Checkbox;
import com.cristian.design.patterns.checkboxes.LinuxCheckbox;

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

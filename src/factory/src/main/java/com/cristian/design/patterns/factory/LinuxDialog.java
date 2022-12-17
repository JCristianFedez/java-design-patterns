package com.cristian.design.patterns.factory;

import com.cristian.design.patterns.butons.Button;
import com.cristian.design.patterns.butons.LinuxButton;

public class LinuxDialog implements Dialog {

  @Override
  public Button createButton() {
    return new LinuxButton();
  }
}

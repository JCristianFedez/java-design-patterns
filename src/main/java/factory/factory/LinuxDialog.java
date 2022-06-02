package factory.factory;

import factory.butons.Button;
import factory.butons.LinuxButton;

public class LinuxDialog implements Dialog {

  @Override
  public Button createButton() {
    return new LinuxButton();
  }
}

package factory.factory;

import factory.butons.Button;
import factory.butons.HtmlButton;

public class HtmlDialog implements Dialog {

  @Override
  public Button createButton() {
    return new HtmlButton();
  }
}

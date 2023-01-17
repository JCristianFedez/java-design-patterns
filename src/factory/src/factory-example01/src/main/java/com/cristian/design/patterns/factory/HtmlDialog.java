package com.cristian.design.patterns.factory;

import com.cristian.design.patterns.butons.Button;
import com.cristian.design.patterns.butons.HtmlButton;

public class HtmlDialog implements Dialog {

  @Override
  public Button createButton() {
    return new HtmlButton();
  }
}

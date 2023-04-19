package com.cristian.design.patterns.app;

import com.cristian.design.patterns.buttons.Button;
import com.cristian.design.patterns.checkboxes.Checkbox;
import com.cristian.design.patterns.factories.Factory;

/**
 * A los usuarios de la Factory no les importa qué Factory concreta usan, ya que trabajan con Factories y productos a través de interfaces
 * abstractas.
 */
public class Application {

  private final Button button;

  private final Checkbox checkbox;

  public Application(final Factory factory) {
    this.button = factory.createButton();
    this.checkbox = factory.createCheckbox();
  }

  public void paint() {
    button.paint();
    checkbox.paint();
  }
}

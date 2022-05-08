package abstractfactory.app;

import abstractfactory.buttons.Button;
import abstractfactory.checkboxes.Checkbox;
import abstractfactory.factories.Factory;

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

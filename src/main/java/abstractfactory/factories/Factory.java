package abstractfactory.factories;

import abstractfactory.buttons.Button;
import abstractfactory.checkboxes.Checkbox;

/**
 * Interfaz que sabe todos los tipos de productos.
 */
public interface Factory {

  Button createButton();

  Checkbox createCheckbox();
}

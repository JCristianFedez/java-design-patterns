package com.cristian.design.patterns.factories;

import com.cristian.design.patterns.buttons.Button;
import com.cristian.design.patterns.checkboxes.Checkbox;

/**
 * Interfaz que sabe todos los tipos de productos.
 */
public interface Factory {

  Button createButton();

  Checkbox createCheckbox();
}

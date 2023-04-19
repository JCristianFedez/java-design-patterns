package com.cristian.design.patterns.buttons;

/**
 * <p>
 * Abstract Factory asume que tiene varias familias de productos, estructurado en jerarquías de clases separadas (botón/casilla de
 * verificación).
 * </p>
 * <p>Todos los productos de la misma familia tiene la interfaz común.</p>
 * <p>Esta es la interfaz común para la familia de botones.</p>
 */
public interface Button {

  void paint();
}

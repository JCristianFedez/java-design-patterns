package factory.factory;

import factory.butons.Button;

public interface Dialog {

  /**
   * Clase de fábrica base. Tenga en cuenta que "fábrica" es simplemente un rol para la clase. Debe tener alguna lógica comercial central
   * que necesite diferentes productos para ser creado.
   */
  default void renderWindow() {
    final Button okButton = createButton();
    okButton.render();
  }

  /**
   * Las subclases anularán este método para crear objetos de botón específicos.
   */
  Button createButton();
}

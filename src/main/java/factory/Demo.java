package factory;

import factory.factory.Dialog;
import factory.factory.HtmlDialog;
import factory.factory.LinuxDialog;

public class Demo {

  private static Dialog dialog;

  public static void main(String[] args) {
    configure();
    runBusinessLogic();
  }

  /**
   * La fábrica concreta suele elegirse en función de las opciones de configuración o entorno.
   */
  private static void configure() {
    if (System.getProperty("os.name").equals("Linux")) {
      dialog = new LinuxDialog();
    } else {
      dialog = new HtmlDialog();
    }
  }

  /**
   * El código del cliente debe funcionar con fábricas y productos a través de interfaces abstractas. De esta forma no le importa con qué
   * fábrica trabaja y qué tipo de producto devuelve.
   */
  private static void runBusinessLogic() {
    dialog.renderWindow();
  }
}

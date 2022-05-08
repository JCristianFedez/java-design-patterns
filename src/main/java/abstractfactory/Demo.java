package abstractfactory;

import abstractfactory.app.Application;
import abstractfactory.factories.Factory;
import abstractfactory.factories.LinuxFactoryImpl;
import abstractfactory.factories.WindowsFactoryImpl;

/**
 * Clase de demostración. Todas las cosas se juntan aquí.
 */
public class Demo {

  public static void main(String[] args) {
    final Application app = configureApplication();
    app.paint();
  }

  /**
   * La aplicación elige el tipo de Factory y lo crea en tiempo de ejecución (generalmente en etapa de inicialización), según la
   * configuración o el entorno variables.
   */
  private static Application configureApplication() {
    final String osName = System.getProperty("os.name").toLowerCase();
    final Factory factory = osName.contains("linux") ? new LinuxFactoryImpl() : new WindowsFactoryImpl();
    return new Application(factory);
  }
}

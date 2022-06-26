package templatemethod.networks;

import java.util.Collections;

public class Facebook extends Network {

  public Facebook(final String userName, final String password) {
    super(userName, password);
  }

  @Override
  boolean logIn(final String userName, final String password) {
    System.out.println("\nComprobando los parámetros de usuario");
    System.out.println("Nombre: " + this.getUserName());
    final String hiddenPassword = String.join("", Collections.nCopies(this.getPassword().length(), "*"));
    System.out.print("Contraseña: " + hiddenPassword);
    this.simulateNetworkLatency();
    System.out.println("\n\nHa iniciado sesión con éxito en Facebook");
    return true;
  }

  @Override
  public boolean sendData(final byte[] data) {
    System.out.printf("Mensaje: %s fue posteado en Facebook%n", new String(data));
    return true;
  }

  @Override
  public void logOut() {
    System.out.printf("Usuario %s ha cerrado sesión en facebook%n", this.getUserName());
  }

  private void simulateNetworkLatency() {
    try {
      int i = 0;
      System.out.println();
      while (i < 10) {
        System.out.print(".");
        Thread.sleep(500);
        i++;
      }
    } catch (InterruptedException ex) {
      ex.printStackTrace();
      Thread.currentThread().interrupt();
    }
  }
}

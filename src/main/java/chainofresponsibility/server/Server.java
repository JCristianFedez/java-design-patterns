package chainofresponsibility.server;

import java.util.HashMap;
import java.util.Map;

import chainofresponsibility.middleware.Middleware;
import commons.logger.Logger;

public class Server {

  private static final Logger LOGGER = Logger.fromType(Server.class);

  private final Map<String, String> users = new HashMap<>();

  private Middleware middleware;

  /**
   * El cliente pasa una cadena de objetos al servidor. Esto mejora la flexibilidad y facilita la prueba de la clase de servidor.
   */
  public void setMiddleware(final Middleware middleware) {
    this.middleware = middleware;
  }

  /**
   * El servidor obtiene el correo electrónico y la contraseña del cliente y envía la solicitud de autorización a la cadena.
   */
  public boolean logIn(final String email, final String password) {
    if (this.middleware.check(email, password)) {
      LOGGER.debug("La autorización ha sido satisfactoria");
      // Haga algo útil aquí para usuarios autorizados.
      return true;
    }
    return false;
  }

  public void register(final String email, final String password) {
    this.users.put(email, password);
  }

  public boolean hasEmail(final String email) {
    return this.users.containsKey(email);
  }

  public boolean isValidPassword(final String email, final String password) {
    return this.users.get(email).equals(password);
  }
}

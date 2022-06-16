package chainofresponsibility.middleware;

import chainofresponsibility.server.Server;
import commons.logger.Logger;

/**
 *  Manejador concreto. Comprueba si existe un usuario con las credenciales proporcionadas.
 */
public class UserExistsMiddleware extends Middleware {

  private static final Logger LOGGER = Logger.fromType(UserExistsMiddleware.class);

  private final Server server;

  public UserExistsMiddleware(final Server server) {
    this.server = server;
  }

  @Override
  public boolean check(final String email, final String password) {
    if (!this.server.hasEmail(email)) {
      LOGGER.debug("Este email no esta registrado");
      return false;
    } else if (!server.isValidPassword(email, password)) {
      LOGGER.debug("Contraseña incorrecta");
      return false;
    }
    return this.checkNext(email, password);
  }
}

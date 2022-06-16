package chainofresponsibility.middleware;

import commons.logger.Logger;

/**
 * Manejador concreto. Revisa el rol de un usuario.
 */
public class RoleCheckMiddleware extends Middleware {

  private static final Logger LOGGER = Logger.fromType(RoleCheckMiddleware.class);

  @Override
  public boolean check(final String email, final String password) {
    if (email.equals("admin@example.com")) {
      LOGGER.debug("Hola admin!");
      return true;
    }
    LOGGER.debug("Hola usuario!");
    return this.checkNext(email, password);
  }
}

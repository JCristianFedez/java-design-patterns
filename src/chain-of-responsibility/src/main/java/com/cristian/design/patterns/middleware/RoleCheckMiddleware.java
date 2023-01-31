package com.cristian.design.patterns.middleware;

import lombok.extern.slf4j.Slf4j;

/**
 * Manejador concreto. Revisa el rol de un usuario.
 */
@Slf4j
public class RoleCheckMiddleware extends Middleware {

  @Override
  public boolean check(final String email, final String password) {
    if (email.equals("admin@example.com")) {
      log.debug("Hola admin!");
      return true;
    }
    log.debug("Hola usuario!");
    return this.checkNext(email, password);
  }
}

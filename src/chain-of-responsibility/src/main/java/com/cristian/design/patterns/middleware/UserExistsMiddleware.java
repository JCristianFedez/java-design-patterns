package com.cristian.design.patterns.middleware;

import com.cristian.design.patterns.server.Server;

import lombok.extern.slf4j.Slf4j;

/**
 * Manejador concreto. Comprueba si existe un usuario con las credenciales proporcionadas.
 */
@Slf4j
public class UserExistsMiddleware extends Middleware {

  private final Server server;

  public UserExistsMiddleware(final Server server) {
    this.server = server;
  }

  @Override
  public boolean check(final String email, final String password) {
    if (!this.server.hasEmail(email)) {
      log.debug("Este email no esta registrado");
      return false;
    } else if (!server.isValidPassword(email, password)) {
      log.debug("Contraseña incorrecta");
      return false;
    }
    return this.checkNext(email, password);
  }
}

package com.cristian.design.patterns.middleware;

import lombok.extern.slf4j.Slf4j;

/**
 * Manejador concreto. Comprueba si hay demasiadas solicitudes de inicio de sesión fallidas.
 */
@Slf4j
public class ThrottlingMiddleware extends Middleware {

  private final int requestPerMinute;

  private int request;

  private long currentTime;

  public ThrottlingMiddleware(final int requestPerMinute) {
    this.requestPerMinute = requestPerMinute;
    this.currentTime = System.currentTimeMillis();
    this.request = 0;
  }

  /**
   * Por favor, no se puede insertar la llamada checkNext() tanto al principio como al final de este método. Esto brinda mucha más
   * flexibilidad que un simple bucle sobre todos los objetos de middleware. Por ejemplo, un elemento de una cadena puede cambiar el orden
   * de las comprobaciones ejecutando su comprobación después de todas las demás comprobaciones.
   */
  @Override
  public boolean check(final String email, final String password) {
    if (System.currentTimeMillis() > this.currentTime + 60_000) {
      this.request = 0;
      this.currentTime = System.currentTimeMillis();
    }

    this.request++;

    if (this.request > this.requestPerMinute) {
      log.debug("Limite de peticiones excedido");
      Thread.currentThread().stop();
    }

    return this.checkNext(email, password);
  }
}

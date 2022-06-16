package chainofresponsibility.middleware;

/**
 * Clase middleware básica.
 */
public abstract class Middleware {

  private Middleware next;

  /**
   * Constructor de la cadena de objetos middleware.
   */
  public Middleware linkWith(final Middleware next) {
    this.next = next;
    return this.next;
  }

  /**
   * Las subclases implementarán este método con los chequeos concretos.
   */
  public abstract boolean check(final String email, final String password);

  /**
   * Ejecuta la comprobación del siguiente objeto de la cadena o finaliza el recorrido si estamos en el último objeto de la cadena.
   */
  protected boolean checkNext(final String email, final String password) {
    if (this.next == null) {
      return true;
    }
    return this.next.check(email, password);
  }
}

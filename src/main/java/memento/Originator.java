package memento;

import commons.logger.Logger;

public class Originator {

  private static final Logger LOGGER = Logger.fromType(Originator.class);

  private String state;

  public void setState(final String state) {
    LOGGER.debug("Modificando estado a %s", state);
    this.state = state;
  }

  public Memento saveToMemento() {
    LOGGER.debug("Guardando en Memento.");
    return new Memento(this.state);
  }

  public void restoreToMemento(final Memento memento) {
    this.state = memento.getSavedState();
    LOGGER.debug("Estado después de restaurar desde Memento %s: ", this.state);
  }
}

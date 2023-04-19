package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Originator {

  private String state;

  public void setState(final String state) {
    LOGGER.debug("Modificando estado a {}", state);
    this.state = state;
  }

  public Memento saveToMemento() {
    LOGGER.debug("Guardando en Memento.");
    return new Memento(this.state);
  }

  public void restoreToMemento(final Memento memento) {
    this.state = memento.getSavedState();
    LOGGER.debug("Estado después de restaurar desde Memento {}: ", this.state);
  }
}

package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Originator {

  private String state;

  public void setState(final String state) {
    log.debug("Modificando estado a {}", state);
    this.state = state;
  }

  public Memento saveToMemento() {
    log.debug("Guardando en Memento.");
    return new Memento(this.state);
  }

  public void restoreToMemento(final Memento memento) {
    this.state = memento.getSavedState();
    log.debug("Estado después de restaurar desde Memento {}: ", this.state);
  }
}

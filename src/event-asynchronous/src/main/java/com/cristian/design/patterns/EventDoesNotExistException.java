package com.cristian.design.patterns;

class EventDoesNotExistException extends Exception {

  private static final long serialVersionUID = 4858706440031109179L;

  public EventDoesNotExistException(final String message) {
    super(message);
  }
}

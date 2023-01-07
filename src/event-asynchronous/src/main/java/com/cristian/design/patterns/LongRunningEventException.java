package com.cristian.design.patterns;

class LongRunningEventException extends Exception {

  private static final long serialVersionUID = -8565702060123937889L;

  public LongRunningEventException(final String message) {
    super(message);
  }
}

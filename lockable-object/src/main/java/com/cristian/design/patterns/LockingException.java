package com.cristian.design.patterns;

import java.io.Serial;

public class LockingException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = -8093419007062231209L;

  public LockingException(final String message) {
    super(message);
  }
}

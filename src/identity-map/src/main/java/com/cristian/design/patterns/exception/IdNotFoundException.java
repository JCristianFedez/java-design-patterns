package com.cristian.design.patterns.exception;

import java.io.Serial;

public class IdNotFoundException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 6771465618425114335L;

  public IdNotFoundException(final String message) {
    super(message);
  }

}

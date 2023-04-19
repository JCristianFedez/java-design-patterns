package com.cristian.design.patterns;

import java.io.Serial;

public class ApplicationException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = -6381890031394939321L;

  public ApplicationException(Throwable cause) {
    super(cause);
  }
}
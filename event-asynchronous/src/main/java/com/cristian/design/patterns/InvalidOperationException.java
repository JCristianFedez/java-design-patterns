package com.cristian.design.patterns;

public class InvalidOperationException extends Exception {

  private static final long serialVersionUID = -2370583331178225143L;

  public InvalidOperationException(final String message) {
    super(message);
  }
}

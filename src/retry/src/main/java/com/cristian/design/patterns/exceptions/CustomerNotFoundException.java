package com.cristian.design.patterns.exceptions;

public class CustomerNotFoundException extends BusinessException {

  public CustomerNotFoundException(final String message) {
    super(message);
  }
}

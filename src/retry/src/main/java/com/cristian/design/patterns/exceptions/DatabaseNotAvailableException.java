package com.cristian.design.patterns.exceptions;

public class DatabaseNotAvailableException extends BusinessException{

  public DatabaseNotAvailableException(final String message) {
    super(message);
  }
}

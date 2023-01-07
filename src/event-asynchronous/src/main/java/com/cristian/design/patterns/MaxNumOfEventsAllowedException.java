package com.cristian.design.patterns;

class MaxNumOfEventsAllowedException extends Exception {

  private static final long serialVersionUID = -641912646681664725L;

  public MaxNumOfEventsAllowedException(final String message) {
    super(message);
  }
}

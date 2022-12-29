package com.cristian.design.patterns;

abstract class Tobocco {

  public void smoke(final Wizard wizard) {
    System.out.printf("%s smoking %s%n", wizard.getClass().getSimpleName(), getClass().getSimpleName());
  }
}

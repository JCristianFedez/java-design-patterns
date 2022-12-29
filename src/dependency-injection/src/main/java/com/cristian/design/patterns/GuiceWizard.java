package com.cristian.design.patterns;

class GuiceWizard implements Wizard {

  private final Tobocco tobocco;

  public GuiceWizard(final Tobocco tobocco) {
    this.tobocco = tobocco;
  }

  @Override
  public void smoke() {
    this.tobocco.smoke(this);
  }
}

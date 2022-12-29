package com.cristian.design.patterns;

class AdvanceWizard implements Wizard {

  private final Tobocco tobocco;

  public AdvanceWizard(final Tobocco tobocco) {
    this.tobocco = tobocco;
  }

  @Override
  public void smoke() {
    this.tobocco.smoke(this);
  }
}

package com.cristian.design.patterns.wizardtower;

import com.cristian.design.patterns.Wizard;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class WizardTowerProxy implements WizardTower {

  private static final int NUM_WIZARD_ALLOWED = 3;

  private final WizardTower tower;

  private int numWizards;

  @Override
  public void enter(final Wizard wizard) {
    if (this.numWizards < NUM_WIZARD_ALLOWED) {
      this.tower.enter(wizard);
      this.numWizards++;
    } else {
      LOGGER.info("{} is not allowed to enter!", wizard);
    }
  }
}

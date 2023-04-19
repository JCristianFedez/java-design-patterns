package com.cristian.design.patterns.wizardtower;

import com.cristian.design.patterns.Wizard;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IvoryTower implements WizardTower {

  @Override
  public void enter(final Wizard wizard) {
    LOGGER.info("{} enters the tower.", wizard);
  }
}

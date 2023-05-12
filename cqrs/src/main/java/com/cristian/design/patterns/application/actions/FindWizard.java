package com.cristian.design.patterns.application.actions;

import java.util.concurrent.TimeUnit;

import com.cristian.design.patterns.domain.Repository;
import com.cristian.design.patterns.domain.creatures.Wizard;
import com.cristian.design.patterns.domain.valueobjects.WizardId;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindWizard {

  private final WizardId wizardId;

  private final Repository repository;

  public FindWizard(final WizardId wizardId, final Repository repository) {
    this.wizardId = wizardId;
    this.repository = repository;
  }

  public Wizard execute() {
    LOGGER.debug("looking for the wizard {}", this.wizardId.id());
    delay();
    return this.repository.findWizardById(this.wizardId.id());
  }

  private synchronized void delay() {
    try {
      this.wait(TimeUnit.SECONDS.toMillis(2));
    } catch (InterruptedException e) {
      LOGGER.error("Error while looking for the wizard {}", this.wizardId.id());
      Thread.currentThread().interrupt();
    }
  }
}

package com.cristian.design.patterns.application.actions;

import java.util.concurrent.TimeUnit;

import com.cristian.design.patterns.domain.Repository;
import com.cristian.design.patterns.domain.creatures.Wizard;
import com.cristian.design.patterns.domain.valueobjects.SpellName;
import com.cristian.design.patterns.domain.valueobjects.WizardId;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {

  private final WizardId wizardId;

  private final SpellName spellName;

  private final Repository repository;

  public SpellCaster(final WizardId wizardId, final SpellName spellName, final Repository repository) {
    this.wizardId = wizardId;
    this.spellName = spellName;
    this.repository = repository;
  }

  public void execute() {
    final Wizard wizard = this.repository.findWizardById(this.wizardId.id());
    LOGGER.debug("{} preparing spell {}", wizard.name(), this.spellName.name());
    delay(wizard);
    LOGGER.debug("{} cast spell {}", wizard.name(), this.spellName.name());
  }

  private synchronized void delay(final Wizard wizard) {
    try {
      this.wait(TimeUnit.SECONDS.toMillis(2));
    } catch (InterruptedException e) {
      LOGGER.error("Error while {} was preparing spell {}", wizard.name(), this.spellName.name());
      Thread.currentThread().interrupt();
    }
  }
}

package com.cristian.design.patterns.application.actions;

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
    LOGGER.debug("{} cast spell {}", wizard.name(), this.spellName.name());
  }
}

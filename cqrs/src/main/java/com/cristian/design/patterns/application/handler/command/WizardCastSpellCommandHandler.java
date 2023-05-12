package com.cristian.design.patterns.application.handler.command;

import com.cristian.design.patterns.application.actions.SpellCaster;
import com.cristian.design.patterns.application.commands.WizardCastSpellCommand;
import com.cristian.design.patterns.domain.Repository;
import com.cristian.design.patterns.domain.valueobjects.SpellName;
import com.cristian.design.patterns.domain.valueobjects.WizardId;

public final class WizardCastSpellCommandHandler implements CommandHandler<WizardCastSpellCommand> {

  private final Repository repository;

  public WizardCastSpellCommandHandler(final Repository repository) {
    this.repository = repository;
  }

  @Override
  public void handle(final WizardCastSpellCommand command) {
    new SpellCaster(new WizardId(command.wizardId()), new SpellName(command.spell()), this.repository).execute();
  }
}

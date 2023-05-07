package com.cristian.design.patterns.infrastructure.adapters.primary;

import com.cristian.design.patterns.application.buses.commands.CommandBus;
import com.cristian.design.patterns.application.commands.WizardCastSpellCommand;
import com.cristian.design.patterns.application.requests.WizardCastSpellRequest;

public final class DemoCommandController {

  private final CommandBus commandBus;

  public DemoCommandController(final CommandBus commandBus) {
    this.commandBus = commandBus;
  }

  public void castSpell(final WizardCastSpellRequest request) {
    final WizardCastSpellCommand command = new WizardCastSpellCommand(request.id(), request.spell());
    this.commandBus.dispatch(command);
  }

}

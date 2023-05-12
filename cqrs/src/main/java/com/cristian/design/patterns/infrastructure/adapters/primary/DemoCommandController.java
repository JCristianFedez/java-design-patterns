package com.cristian.design.patterns.infrastructure.adapters.primary;

import java.util.concurrent.CompletableFuture;

import com.cristian.design.patterns.application.buses.commands.CommandBus;
import com.cristian.design.patterns.application.commands.WizardCastSpellCommand;
import com.cristian.design.patterns.application.requests.WizardCastSpellRequest;

public final class DemoCommandController {

  private final CommandBus commandBus;

  public DemoCommandController(final CommandBus commandBus) {
    this.commandBus = commandBus;
  }

  public CompletableFuture<Void> castSpell(final WizardCastSpellRequest request) {
    final WizardCastSpellCommand command = new WizardCastSpellCommand(request.id(), request.spell());
    return this.commandBus.dispatch(command);
  }

}

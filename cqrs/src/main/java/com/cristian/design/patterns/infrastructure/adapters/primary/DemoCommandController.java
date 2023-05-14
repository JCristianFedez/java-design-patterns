package com.cristian.design.patterns.infrastructure.adapters.primary;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import com.cristian.design.patterns.application.buses.commands.CommandBus;
import com.cristian.design.patterns.application.commands.WizardCastSpellCommand;
import com.cristian.design.patterns.application.requests.WizardCastSpellRequest;

public final class DemoCommandController {


  private final CommandBus commandBus;

  public DemoCommandController(final CommandBus commandBus) {
    this.commandBus = commandBus;
  }

  public void castSpellSync(final WizardCastSpellRequest request) {
    castSpell(request);
  }

  public CompletableFuture<Void> castSpellAsync(final ExecutorService executorService, final WizardCastSpellRequest request) {
    final CompletableFuture<Void> future = new CompletableFuture<>();
    executorService.submit(() -> {
      castSpell(request);
      future.complete(null);
    });
    return future;
  }

  private void castSpell(final WizardCastSpellRequest request) {
    final WizardCastSpellCommand command = new WizardCastSpellCommand(request.id(), request.spell());
    this.commandBus.dispatch(command);
  }
}
